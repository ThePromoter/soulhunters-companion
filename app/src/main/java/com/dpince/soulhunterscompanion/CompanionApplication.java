package com.dpince.soulhunterscompanion;

import android.app.Application;
import android.content.Context;

import com.dpince.soulhunterscompanion.di.component.AppComponent;
import com.dpince.soulhunterscompanion.di.component.DaggerAppComponent;
import com.dpince.soulhunterscompanion.di.component.UserComponent;
import com.dpince.soulhunterscompanion.di.module.AppModule;
import com.dpince.soulhunterscompanion.di.module.UserModule;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

public class CompanionApplication extends Application {

    private static final String LOG_TAG = CompanionApplication.class.getSimpleName();

    protected AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected UserComponent userComponent;

    public UserComponent getUserComponent() {
        return userComponent;
    }

    public static CompanionApplication get(Context context) {
        return (CompanionApplication) context.getApplicationContext();
    }

    @Override public void onCreate() {
        super.onCreate();

        initAppComponent();
        initUserComponent();
        injectDependencies();
    }

    protected void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                                         .appModule(new AppModule(this))
                                         .build();
    }

    protected void initUserComponent() {
        userComponent = appComponent.plus(new UserModule());
    }

    protected void injectDependencies() {
        CompanionApplication.get(this)
                            .getAppComponent()
                            .inject(this);
    }
}
