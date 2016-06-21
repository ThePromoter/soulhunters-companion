package com.dpince.soulhunterscompanion.menu;

import com.dpince.soulhunterscompanion.base.presenter.RxMvpPresenter;
import com.dpince.soulhunterscompanion.model.User;

import javax.inject.Inject;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class MenuHeaderPresenter
    extends RxMvpPresenter<MenuHeaderView, User> {

    @Inject MenuHeaderPresenter() {
        super();
    }
}
