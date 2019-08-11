package com.svapp.coroutinessandbox.data.repository

import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 03.03.2019.
 */
interface IContributorsRepository {

    suspend fun getRepoContributors(owner: String, repoName: String): ResultListener<List<Contributor>>

    suspend fun getUserByLogin(): ResultListener<Contributor>

}