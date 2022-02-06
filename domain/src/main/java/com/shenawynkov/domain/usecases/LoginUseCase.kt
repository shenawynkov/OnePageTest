package com.shenawynkov.domain.usecases

import com.shenawynkov.domain.repositories.ContactsRepo
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repo: ContactsRepo) {
    operator fun invoke(userID:String,apiKey:String) = repo.login(userID,apiKey)
     fun isUserLoggedIn() :Boolean= repo.isUserLoggedIn()

}