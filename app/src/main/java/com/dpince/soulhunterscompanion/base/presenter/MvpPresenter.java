package com.dpince.soulhunterscompanion.base.presenter;

import com.dpince.soulhunterscompanion.base.view.MvpView;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public interface MvpPresenter<V extends MvpView> {

    /**
     * Set or attach the view to this presenter
     */
    void attachView(V view);

    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
    boolean isViewAttached();

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is attached to avoid NullPointerExceptions.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    V getView();

    /**
     * Called when the view has been destroyed. Typically this method will be invoked from
     * <code>Activity#detachView()</code> or <code>Fragment#onDestroyView()</code>
     */
    void detachView(boolean retainInstance);
}
