package com.svapp.coroutinessandbox.presentation.contributors

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
class ContributorsViewModel(private val repo: IContributorsRepository) : BaseViewModel() {

    private val _contributorsLiveData = MutableLiveData<List<Contributor>>()
    val contributorsLiveData: LiveData<List<Contributor>> = _contributorsLiveData

    init {
        getContributors()
    }

    private fun getContributors() {
        viewModelScope.launch {
            repo.getRepoContributors("square", "retrofit").handleResult {
                _contributorsLiveData.value = it
            }
        }
    }

}