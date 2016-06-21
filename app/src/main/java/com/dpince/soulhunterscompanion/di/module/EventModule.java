package com.dpince.soulhunterscompanion.di.module;

import com.dpince.soulhunterscompanion.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * @author dpinciotti
 * @createdDate 6/20/16
 */

@Module
public class EventModule {

    @Provides @ApplicationScope
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }
}
