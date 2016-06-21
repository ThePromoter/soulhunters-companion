package com.dpince.soulhunterscompanion.menu;

import com.dpince.soulhunterscompanion.CompanionApplication;
import com.dpince.soulhunterscompanion.R;
import com.dpince.soulhunterscompanion.base.view.fragment.BaseRxMvpFragment;
import com.dpince.soulhunterscompanion.di.module.AppSectionModule;
import com.dpince.soulhunterscompanion.model.AppSection;

import java.util.List;

import javax.inject.Inject;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class MenuNavigationFragment
    extends BaseRxMvpFragment<List<AppSection>, MenuNavigationView, MenuNavigationPresenter>
    implements MenuNavigationView {

    @Inject MenuNavigationPresenter presenter;

    @Override protected int getLayoutRes() {
        return R.layout.fragment_menu_navigation;
    }

    @Override public MenuNavigationPresenter createPresenter() {
        return presenter;
    }

    @Override protected void injectDependencies() {
        CompanionApplication.get(getContext())
                            .getAppComponent()
                            .plus(new AppSectionModule())
                            .inject(this);
    }
}
