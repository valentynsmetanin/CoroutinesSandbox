package com.svapp.coroutinessandbox.data.repository

import androidx.lifecycle.LiveData
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor

/**
 * Created by Valentyn on 03.03.2019.
 */
interface ContributorsRepository {

    fun getRepoContributors(resultListener: ResultListener<LiveData<List<Contributor>>>)

    fun getUserByLogin(resultListener: ResultListener<LiveData<Contributor>>)

}