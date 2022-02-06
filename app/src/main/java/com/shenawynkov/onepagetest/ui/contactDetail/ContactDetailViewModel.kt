package com.shenawynkov.onepagetest.ui.contactDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shenawynkov.domain.model.contact.ContactX

class ContactDetailViewModel:ViewModel() {
    val contact=MutableLiveData<ContactX>()
}