package com.svapp.coroutinessandbox.presentation.contributors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.repository.ContributorsRepository

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorsViewModel(private val repo: ContributorsRepository) : ViewModel() {

    var contributorsLiveData: LiveData<List<Contributor>>? = null

    init {
        getContributors()
    }

    private fun getContributors() {
        repo.getRepoContributors(object : ResultListener<LiveData<List<Contributor>>> {
            override fun onResult(result: LiveData<List<Contributor>>?) {
                contributorsLiveData = result
            }

            override fun onError(error: Throwable?) {
                // do nothing for now
            }
        })
    }

}