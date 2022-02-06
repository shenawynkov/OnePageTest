package com.shenawynkov.data.repo


import com.shenawynkov.data.apiService.ApiService
import com.shenawynkov.data.mapper.mapToContactx
import com.shenawynkov.data.sharedPref.PrefManger
import com.shenawynkov.domain.repositories.ContactsRepo
import com.shenawynkov.domain.model.contact.ContactX
import com.shenawynkov.domain.model.contact.BaseResponse
import com.shenawynkov.domain.model.contact.ContactsResponse
import io.reactivex.SingleSource
import com.shenawynkov.domain.model.contact.Contact
import io.reactivex.Single
import io.reactivex.Single.error
import io.reactivex.schedulers.Schedulers.io
import okhttp3.Credentials
import java.util.ArrayList

class ContactsRepoImpl(private val apiService: ApiService, private val prefManger: PrefManger) :
    ContactsRepo {
    override fun getContacts(): Single<List<ContactX>> {
        return apiService.getContacts(Credentials.basic(prefManger.userId, prefManger.apiKey))
            .flatMap { response ->
                Single.just(
                    response.data.contacts.mapToContactx()
                )
            }

    }


    override fun login(userId: String, apiKey: String) {
        prefManger.saveApiKey(apiKey)
        prefManger.saveUserId(userId)
    }

    override fun isUserLoggedIn(): Boolean {
        return prefManger.isUserLoggedIn
    }
}