package com.shenawynkov.domain.model.contact

data class Company(
    val address: Address,
    val company_fields: List<Any>,
    val contacts_count: Int,
    val created_at: String,
    val description: String,
    val id: String,
    val modified_at: String,
    val name: String,
    val phone: String,
    val synced_status_id: Any,
    val synced_tags: Any,
    val syncing_status: Boolean,
    val syncing_tags: Boolean,
    val url: String
)