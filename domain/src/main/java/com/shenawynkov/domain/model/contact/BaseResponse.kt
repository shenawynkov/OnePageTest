package com.shenawynkov.domain.model.contact

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class BaseResponse<T>(
    val status: Int,
    val message: String,
    val timestamp: Long,
    val data: T
)
