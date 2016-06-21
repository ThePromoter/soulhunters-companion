package com.dpince.soulhunterscompanion.base.view;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.dpince.soulhunterscompanion.base.presenter.BaseMvpPresenter;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public interface MvpView<V> {

    /**
     * Get the casted MvpView for the presenter
     *
     * @return The view associated with the presenter
     */
    @NonNull V getMvpView();

    /**
     * Indicate whether the retain instance feature is enabled by this view or not
     *
     * @return true if the view has enabled retaining, otherwise false.
     * @see android.support.v4.app.Fragment#setRetainInstance(boolean)
     */
    boolean isRetainInstance();

    /**
     * Indicates whether or not the the view will be retained during next screen orientation change.
     * This boolean flag is used for {@link BaseMvpPresenter#detachView(boolean)}
     * as parameter. Usually you should take {@link Activity#isChangingConfigurations()} into
     * account. The difference between {@link #shouldInstanceBeRetained()} and {@link
     * #isRetainInstance()} is that {@link #isRetainInstance()} indicates that retain instance
     * feature is enabled or disabled while {@link #shouldInstanceBeRetained()} indicates if the
     * view is going to be destroyed permanently and hence should no more be retained (i.e. Activity
     * is finishing and not just screen orientation changing)
     *
     * @return true if the instance should be retained, otherwise false
     */
    boolean shouldInstanceBeRetained();
}
