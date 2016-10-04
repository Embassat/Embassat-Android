package com.embassat.app.module

import android.content.Context
import com.embassat.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}