package com.shenawynkov.onepagetest.di

import android.content.SharedPreferences
import com.shenawynkov.data.sharedPref.PrefManger
import com.shenawynkov.onepagetest.BaseSchedulerProvider
import com.shenawynkov.onepagetest.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SchedulerModule {
    @Singleton
    @Provides
    fun provideScheduler(): BaseSchedulerProvider {
        return SchedulerProvider()
    }
}