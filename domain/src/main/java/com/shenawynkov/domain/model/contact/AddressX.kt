package com.shenawynkov.domain.model.contact

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressX(
    val address: String,
    val city: String,
    val country_code: String,
    val state: String,
    val type: String,
    val zip_code: String
):Parcelable