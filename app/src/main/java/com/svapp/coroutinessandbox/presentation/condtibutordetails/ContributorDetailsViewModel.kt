package com.svapp.coroutinessandbox.presentation.condtibutordetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.repository.IContributorsRepository
import com.svapp.coroutinessandbox.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorDetailsViewModel(private val repo: IContributorsRepository) : BaseViewModel() {

    private val _contributorLiveData = MutableLiveData<Contributor>()
    val contributorLiveData: LiveData<Contributor> = _contributorLiveData

    fun start(login: String) {

    }

    private fun getContributor(login: String) {
        viewModelScope.launch {
            repo.getRepoContributors("square", "retrofit").handleResult {
               // _contributorsLiveData.value = it
            }
        }
    }

}