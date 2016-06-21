package com.dpince.soulhunterscompanion.menu;

import com.dpince.soulhunterscompanion.CompanionApplication;
import com.dpince.soulhunterscompanion.R;
import com.dpince.soulhunterscompanion.base.view.fragment.BaseRxMvpFragment;
import com.dpince.soulhunterscompanion.model.User;

import javax.inject.Inject;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class MenuHeaderFragment
    extends BaseRxMvpFragment<User, MenuHeaderView, MenuHeaderPresenter>
    implements MenuHeaderView {

    @Inject MenuHeaderPresenter presenter;

    @Override protected int getLayoutRes() {
        return R.layout.fragment_menu_header;
    }

    @Override public MenuHeaderPresenter createPresenter() {
        return presenter;
    }

    @Override protected void injectDependencies() {
        CompanionApplication.get(getContext())
                            .getUserComponent()
                            .inject(this);
    }
}
