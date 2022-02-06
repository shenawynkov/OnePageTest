package com.shenawynkov.domain.repositories

import com.shenawynkov.domain.model.contact.ContactX
import io.reactivex.Single

import kotlinx.coroutines.flow.Flow


interface ContactsRepo {
     fun getContacts(): Single<List<ContactX>>
     fun login(userId:String,apiKey:String)
     fun isUserLoggedIn():Boolean

}