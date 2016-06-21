package com.dpince.soulhunterscompanion.di.module;

import android.app.Application;

import com.dpince.soulhunterscompanion.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @ApplicationScope
    public Application provideApplication() {
        return application;
    }
}
