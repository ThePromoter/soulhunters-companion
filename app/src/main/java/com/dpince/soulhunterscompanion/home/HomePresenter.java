package com.dpince.soulhunterscompanion.home;

import com.dpince.soulhunterscompanion.base.presenter.RxMvpPresenter;

import javax.inject.Inject;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class HomePresenter
    extends RxMvpPresenter<HomeView, Object> {

    @Inject HomePresenter() {
        super();
    }
}
