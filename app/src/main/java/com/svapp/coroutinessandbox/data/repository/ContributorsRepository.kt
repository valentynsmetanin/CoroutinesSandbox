package com.svapp.coroutinessandbox.data.repository

import androidx.lifecycle.LiveData
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.network.ContributorService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsRepository(private val contributorService: ContributorService) : IContributorsRepository {

    override fun getRepoContributors(resultListener: ResultListener<List<Contributor>>) {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                contributorService.getContributorsAsync("square", "retrofit").await()
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    resultListener.onResult(it)
                }
            }.onFailure {
                withContext(Dispatchers.Main) {
                    resultListener.onError(it)
                }
            }
        }
    }

    override fun getUserByLogin(resultListener: ResultListener<LiveData<Contributor>>) {

    }
}