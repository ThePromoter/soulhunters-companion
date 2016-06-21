package com.dpince.soulhunterscompanion.base.view.fragment;

import com.dpince.soulhunterscompanion.base.presenter.RxMvpPresenter;
import com.dpince.soulhunterscompanion.base.view.RxMvpView;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public abstract class BaseRxMvpFragment<M, V extends RxMvpView, P extends RxMvpPresenter<V, M>>
    extends BaseMvpFragment<V, P>
    implements RxMvpView<M> {

}
