package com.dpince.soulhunterscompanion.di.component;

import com.dpince.soulhunterscompanion.CompanionApplication;
import com.dpince.soulhunterscompanion.di.module.AppModule;
import com.dpince.soulhunterscompanion.di.module.AppSectionModule;
import com.dpince.soulhunterscompanion.di.module.EventModule;
import com.dpince.soulhunterscompanion.di.module.RxSchedulerModule;
import com.dpince.soulhunterscompanion.di.module.UserModule;
import com.dpince.soulhunterscompanion.di.scope.ApplicationScope;
import com.dpince.soulhunterscompanion.home.HomeActivity;

import dagger.Component;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@ApplicationScope
@Component(
    // All of these modules are available to inject anywhere
    modules = {
        AppModule.class,
        EventModule.class,
        RxSchedulerModule.class
    }
)
public interface AppComponent {

    // If your class doesn't have additional modules that are not already accounted
    // for in this component, simply make an inject method for it here
    void inject(CompanionApplication application);
    void inject(HomeActivity activity);

    // Otherwise if you require additional modules, create a subcomponent and create a
    // plus method for it here
    AppSectionComponent plus(AppSectionModule module);

    // Everything else will require a logged in user, and should be included in this subcomponent
    UserComponent plus(UserModule module);
}
