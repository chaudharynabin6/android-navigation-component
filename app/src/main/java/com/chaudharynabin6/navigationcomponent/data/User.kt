package com.chaudharynabin6.navigationcomponent.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


//https://developer.android.com/guide/navigation/navigation-pass-data

// video
//https://www.youtube.com/watch?v=vtAHzpmibXo
@Parcelize
@Keep
@Serializable
data class User(
    val name: String,
    val id: Long,
) : Parcelable