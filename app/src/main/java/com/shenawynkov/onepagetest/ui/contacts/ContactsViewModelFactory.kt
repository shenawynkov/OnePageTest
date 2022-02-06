package com.shenawynkov.onepagetest.ui.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shenawynkov.domain.usecases.ContactsUseCase
import com.shenawynkov.onepagetest.BaseSchedulerProvider
import javax.inject.Inject


class ContactsViewModelFactory
@Inject constructor(
    private val schedulerProvider: BaseSchedulerProvider,
    private val contactsUseCase: ContactsUseCase
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactsViewModel(
            schedulerProvider,
            contactsUseCase
        ) as T
    }


}