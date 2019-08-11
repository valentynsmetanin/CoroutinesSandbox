package com.svapp.coroutinessandbox.data.repository

import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.network.ContributorService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsRepository(private val contributorService: ContributorService) : IContributorsRepository {

    override suspend fun getRepoContributors(owner: String, repoName: String): ResultListener<List<Contributor>> {
        return runCatching {
            withContext(Dispatchers.IO) {
                contributorService.getContributorsAsync(owner, repoName).await()?.let {
                    ResultListener.Success(it)
                } ?: run { ResultListener.Error(Exception("Empty")) }
            }
        }.onFailure {
            ResultListener.Error(it)
        }.getOrDefault(ResultListener.Success(emptyList()))
    }

    override suspend fun getUserByLogin(): ResultListener<Contributor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}