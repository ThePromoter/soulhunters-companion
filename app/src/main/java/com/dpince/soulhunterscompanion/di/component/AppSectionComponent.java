package com.dpince.soulhunterscompanion.di.component;

import com.dpince.soulhunterscompanion.di.module.AppSectionModule;
import com.dpince.soulhunterscompanion.di.scope.ApplicationScope;
import com.dpince.soulhunterscompanion.menu.MenuNavigationFragment;

import dagger.Subcomponent;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@ApplicationScope
@Subcomponent(
    modules = {
        AppSectionModule.class
    }
)
public interface AppSectionComponent {

    void inject(MenuNavigationFragment fragment);
}
