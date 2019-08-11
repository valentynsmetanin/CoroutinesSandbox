package com.svapp.coroutinessandbox.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Valentyn on 03.03.2019.
 */
data class Contributor(
    @SerializedName("id")
    var id: Long,
    @SerializedName("login")
    val login: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("contributions")
    val contributions: Int? = 0,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    // TODO add serializable names
    val name: String?,
    val company: String?,
    val email: String?,
    val location: String?
)