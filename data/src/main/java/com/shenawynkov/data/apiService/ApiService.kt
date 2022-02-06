package com.shenawynkov.data.apiService

import com.shenawynkov.data.Constants.contacts
import com.shenawynkov.domain.model.contact.BaseResponse
import com.shenawynkov.domain.model.contact.ContactsResponse

import com.shenawynkov.domain.model.contact.SectionDetail

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiService {

    @GET(contacts)
    fun getContacts(@Header("Authorization") credentials: String,
                    @Query("page") page:Int=1,
                    @Query("per_page") count:Int=10,
                    @Header ("accept") type:String="application/json"): Single<BaseResponse<ContactsResponse>>

}