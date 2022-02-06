package com.shenawynkov.onepagetest.di

import com.shenawynkov.data.apiService.ApiService
import com.shenawynkov.data.repo.ContactsRepoImpl
import com.shenawynkov.data.sharedPref.PrefManger
import com.shenawynkov.domain.repositories.ContactsRepo


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideContactsRepo(apiService: ApiService,prefManger: PrefManger): ContactsRepo {
        return ContactsRepoImpl(apiService,prefManger)
    }

}