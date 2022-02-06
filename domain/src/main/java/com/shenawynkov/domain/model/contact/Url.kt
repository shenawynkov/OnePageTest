package com.shenawynkov.domain.model.contact

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Url(
    val type: String,
    val value: String
):Parcelable