package com.dpince.soulhunterscompanion.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.dpince.soulhunterscompanion.base.presenter.MvpPresenter;
import com.dpince.soulhunterscompanion.base.view.MvpView;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

abstract class BaseMvpFragment<V extends MvpView, P extends MvpPresenter<V>>
    extends BaseFragment
    implements MvpView {

    private static final String LOG_TAG = BaseMvpFragment.class.getSimpleName();

    /**
     * The presenter for this view. Will be instantiated with {@link #createPresenter()}
     */
    protected P presenter;

    @NonNull @Override public V getMvpView() {
        return (V) this;
    }

    /**
     * Creates a new presenter instance, if needed. Will reuse the previous presenter instance if
     * {@link #setRetainInstance(boolean)} is set to true. This method will be called from
     * {@link #onViewCreated(View, Bundle)}
     */
    public abstract P createPresenter();

    /**
     * Returns the presenter
     * @return P the non-null presenter
     */
    @NonNull public P getPresenter() {
        return presenter;
    }

    /**
     * Sets the presenter.
     * This method will be called from {@link #onViewCreated(View, Bundle)}
     * @param presenter the presenter
     */
    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    protected boolean isRestoringViewState() {
        //TODO add ViewState support
        return false;
    }

    @Override public boolean isRetainInstance() {
        return getRetainInstance();
    }

    @Override public boolean shouldInstanceBeRetained() {
        FragmentActivity activity = getActivity();
        boolean changingConfig = activity != null && activity.isChangingConfigurations();
        return isRetainInstance() && changingConfig;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
            if (presenter == null) throw new AssertionError("Presenter should not be null");
        }

        setPresenter(presenter);
        getPresenter().attachView(getMvpView());
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView(shouldInstanceBeRetained());
    }
}

