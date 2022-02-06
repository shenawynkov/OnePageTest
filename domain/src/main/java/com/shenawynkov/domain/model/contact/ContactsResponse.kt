package com.shenawynkov.domain.model.contact

data class ContactsResponse(
    val contacts: List<Contact>,
    val max_page: Int,
    val page: Int,
    val per_page: Int,
    val total_count: Int
)