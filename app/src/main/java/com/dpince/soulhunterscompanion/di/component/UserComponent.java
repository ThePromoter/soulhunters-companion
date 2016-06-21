package com.dpince.soulhunterscompanion.di.component;

import com.dpince.soulhunterscompanion.di.module.UserModule;
import com.dpince.soulhunterscompanion.di.scope.UserScope;
import com.dpince.soulhunterscompanion.menu.MenuHeaderFragment;

import dagger.Subcomponent;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@UserScope
@Subcomponent(
    modules = {
        UserModule.class
    }
)
public interface UserComponent {

    // If your class doesn't have additional modules that are not already accounted
    // for in this component or in AppComponent, simply make an inject method for it here
    void inject(MenuHeaderFragment fragment);

    // Otherwise if you require additional modules, create a subcomponent and create a
    // plus method for it here
}
