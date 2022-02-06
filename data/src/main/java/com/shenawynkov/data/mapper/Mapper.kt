package com.shenawynkov.data.mapper

import com.shenawynkov.domain.model.contact.Contact
import com.shenawynkov.domain.model.contact.ContactX


fun List<Contact>.mapToContactx(): List<ContactX> {
    return map { contact ->
      contact.contact
    }
}




