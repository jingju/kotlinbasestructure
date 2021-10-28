package com.doit.network.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfoBean(
    val avatar: String,
    val birthday: Long,
    val nickName: String,
    val sex: Int,
    val age:Int
) : Parcelable {

}