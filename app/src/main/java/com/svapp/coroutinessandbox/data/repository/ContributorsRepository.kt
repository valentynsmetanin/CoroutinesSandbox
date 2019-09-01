package com.svapp.coroutinessandbox.data.repository

import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.network.ContributorService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsRepository(private val contributorService: ContributorService) :
    IContributorsRepository {

    override suspend fun getRepoContributors(owner: String, repoName: String) = runCatching {
        withContext(Dispatchers.IO) {
            contributorService.getContributors(owner, repoName)?.let {
                ResultListener.Success(it)
            } ?: run { ResultListener.Error(Exception("Empty")) }
        }
    }.onFailure {
        ResultListener.Error(it)
    }.getOrDefault(ResultListener.Success(emptyList()))

    override suspend fun getContributorByLogin(login: String) = runCatching {
        withContext(Dispatchers.IO) {
            contributorService.getContributor(login)?.let {
                ResultListener.Success(it)
            } ?: run { ResultListener.Error(Exception("Not found")) }
        }
    }.onFailure {
        ResultListener.Error(it)
    }.getOrDefault(ResultListener.Error(Exception("Not found")))

}