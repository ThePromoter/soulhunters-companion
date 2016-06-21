package com.dpince.soulhunterscompanion.base.view.activity;

import android.os.Bundle;

import com.dpince.soulhunterscompanion.base.presenter.RxMvpPresenter;
import com.dpince.soulhunterscompanion.base.view.RxMvpView;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class BaseRxMvpActivity<M, V extends RxMvpView, P extends RxMvpPresenter<V, M>>
    extends BaseMvpActivity<V, P>
    implements RxMvpView<M> {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override protected void onStart() {
        super.onStart();
    }
}
