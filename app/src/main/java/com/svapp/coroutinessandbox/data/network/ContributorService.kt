package com.svapp.coroutinessandbox.data.network

import com.svapp.coroutinessandbox.data.model.Contributor
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Valentyn on 03.03.2019.
 */
interface ContributorService {

    @GET("/repos/{owner}/{repo}/contributors")
    suspend fun getContributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<Contributor>?

    @GET("/users/{login}")
    suspend fun getContributor(@Path("login") login: String?): Contributor?
}