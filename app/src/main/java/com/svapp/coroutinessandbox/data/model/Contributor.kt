package com.svapp.coroutinessandbox.data.model

/**
 * Created by Valentyn on 03.03.2019.
 */
data class Contributor(
    var id: Long,
    val login: String?,
    val url: String?,
    val contributions: Int? = 0,
    val avatarUrl: String?,
    val name: String?,
    val company: String?,
    val email: String?,
    val location: String?
)