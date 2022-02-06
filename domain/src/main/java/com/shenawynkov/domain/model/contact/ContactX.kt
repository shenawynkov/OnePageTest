package com.shenawynkov.domain.model.contact

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactX(
    val address_list: List<AddressX>,
    val background: String,
    val company_id: String,
    val company_name: String,
    val company_size: Int,
    val created_at: String,
    val email_sync_available: Boolean,
    val email_sync_enabled: Boolean,
    val emails: List<Email>,
    val enhanceable: Boolean,
    val first_name: String,
    val id: String,
    val job_title: String,
    val last_name: String,
    val lead_source_id: String,
    val letter: String,
    val modified_at: String,
    val owner_id: String,
    val pending_deal: Boolean,
    val phones: List<Phone>,
    val photo_url: String,
    val starred: Boolean,
    val status: String,
    val status_id: String,
    val tags: List<String>,
    val total_deals_count: Int,
    val total_pendings: Int,
    val urls: List<Url>
):Parcelable
{
    var expanded:Boolean=false
    fun alterVisabilty()
    {
        expanded= !expanded
    }
}