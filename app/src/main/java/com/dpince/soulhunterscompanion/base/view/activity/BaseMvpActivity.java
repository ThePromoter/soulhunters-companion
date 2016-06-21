package com.dpince.soulhunterscompanion.base.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dpince.soulhunterscompanion.base.presenter.MvpPresenter;
import com.dpince.soulhunterscompanion.base.view.MvpView;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

abstract class BaseMvpActivity<V extends MvpView, P extends MvpPresenter<V>>
    extends BaseActivity
    implements MvpView {

    protected boolean retainInstance;

    /**
     * The presenter for this view. Will be instantiated with {@link #createPresenter()}
     */
    protected P presenter;

    /**
     * Instantiate a presenter instance
     * @return The {@link MvpPresenter} for this view
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
     * This method will be called from {@link #onCreate(Bundle)}
     * If you need to keep your presenter around during a rotation change, you'll need
     * to override this method in the same class that @Injects the presenter, so that this
     * base class can override the injected presenter with the previously saved one
     * @param presenter the presenter
     */
    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    /**
     * Get the casted MvpView for the presenter
     * @return The view associated with the presenter
     */
    @NonNull public V getMvpView() {
        return (V) this;
    }

    protected boolean isRestoringViewState() {
        //TODO add ViewState support
        return false;
    }

    public boolean isRetainInstance() {
        return retainInstance;
    }

    public boolean shouldInstanceBeRetained() {
        return isRetainInstance() && isChangingConfigurations();
    }

    public void setRetainInstance(boolean retainInstance) {
        this.retainInstance = retainInstance;
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        P savedPresenter = (P) getLastCustomNonConfigurationInstance();

        // If we have a saved presenter, use that...otherwise create a new one
        presenter = savedPresenter != null ? savedPresenter : createPresenter();

        setPresenter(presenter);
        getPresenter().attachView(getMvpView());
    }

    @Override public void onContentChanged() {
        super.onContentChanged();
    }

    @Override public Object onRetainCustomNonConfigurationInstance() {
        return shouldInstanceBeRetained() ? getPresenter() : null;
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView(shouldInstanceBeRetained());
    }

    protected abstract void injectDependencies();
}
