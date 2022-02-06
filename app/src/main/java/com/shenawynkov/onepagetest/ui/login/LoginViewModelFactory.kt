package com.shenawynkov.onepagetest.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shenawynkov.domain.usecases.ContactsUseCase
import com.shenawynkov.domain.usecases.LoginUseCase
import com.shenawynkov.onepagetest.ui.contacts.ContactsViewModel
import javax.inject.Inject


class LoginViewModelFactory
@Inject constructor(private val loginUseCase: LoginUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(
            loginUseCase
        ) as T
    }


}