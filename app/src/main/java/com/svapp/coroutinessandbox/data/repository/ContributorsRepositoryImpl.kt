package com.svapp.coroutinessandbox.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.network.ContributorService
import kotlinx.coroutines.*

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsRepositoryImpl(private val contributorService: ContributorService) : ContributorsRepository {

    override fun getRepoContributors(resultListener: ResultListener<LiveData<List<Contributor>>>) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = contributorService.getContributors("square", "retrofit")
            withContext(Dispatchers.Main) {
                try {
                    val liveData = MutableLiveData<List<Contributor>>()
                    liveData.postValue(request.await())
                    resultListener.onResult(liveData)
                } catch (e: Throwable) {
                    Log.d("A","Ooops: Something else went wrong")
                }
            }
        }
    }

    override fun getUserByLogin(resultListener: ResultListener<LiveData<Contributor>>) {

    }
}