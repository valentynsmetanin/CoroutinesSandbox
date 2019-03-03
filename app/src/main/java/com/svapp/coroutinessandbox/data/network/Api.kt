package com.svapp.coroutinessandbox.data.network

import com.svapp.coroutinessandbox.data.model.Contributor
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Valentyn on 03.03.2019.
 */
interface Api {
    @GET("/repos/{owner}/{repo}/contributors")
    fun repoContributors(@Path("owner") owner: String, @Path("repo") repo: String): Callback<List<Contributor>>

    @GET("/users/{login}")
    fun getContributor(@Path("login") login: String?): Callback<Contributor>
}