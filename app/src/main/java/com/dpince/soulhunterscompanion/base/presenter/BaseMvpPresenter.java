package com.dpince.soulhunterscompanion.base.presenter;

import android.support.annotation.Nullable;

import com.dpince.soulhunterscompanion.base.view.MvpView;

import java.lang.ref.WeakReference;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class BaseMvpPresenter<V extends MvpView, M> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;

    @Override public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override @Nullable public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @Override public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}