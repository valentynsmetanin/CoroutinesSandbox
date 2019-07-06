package com.svapp.coroutinessandbox.presentation.contributors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.repository.IContributorsRepository

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorsViewModel(private val repo: IContributorsRepository) : ViewModel() {

    val contributorsLiveData
        get() = _valuesLiveData

    private var _valuesLiveData: MutableLiveData<List<Contributor>> = MutableLiveData()

    init {
        getContributors()
    }

    private fun getContributors() {
        repo.getRepoContributors(object : ResultListener<List<Contributor>> {
            override fun onResult(result: List<Contributor>?) {
                _valuesLiveData.value = result
            }

            override fun onError(error: Throwable?) {
                // do nothing for now
            }
        })
    }

}