package com.dpince.soulhunterscompanion.di.module;

import com.dpince.soulhunterscompanion.di.scope.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@Module
public class RxSchedulerModule {

    @Provides @ApplicationScope @Named("UIScheduler")
    public Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides @ApplicationScope @Named("IOScheduler")
    public Scheduler provideIoScheduler() {
        return Schedulers.io();
    }
}
