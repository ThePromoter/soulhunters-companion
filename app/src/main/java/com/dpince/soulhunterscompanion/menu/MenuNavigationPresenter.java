package com.dpince.soulhunterscompanion.menu;

import com.dpince.soulhunterscompanion.base.presenter.RxMvpPresenter;
import com.dpince.soulhunterscompanion.model.AppSection;

import java.util.List;

import javax.inject.Inject;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class MenuNavigationPresenter
    extends RxMvpPresenter<MenuNavigationView, List<AppSection>> {

    @Inject MenuNavigationPresenter() {
        super();
    }
}
