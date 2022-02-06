package com.shenawynkov.onepagetest.di;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.shenawynkov.data.sharedPref.PrefManger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataModule {

    @Singleton
    @Provides
    SharedPreferences provideSharedPref(@ApplicationContext Context context) {
        String MY_PREFS_NAME = "user";
        return context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

    }
    @Singleton
    @Provides
    PrefManger providePrefManger(SharedPreferences prefs) {
        return new PrefManger(prefs);


    }

}
