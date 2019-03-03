package com.svapp.coroutinessandbox.data.repository

import androidx.lifecycle.LiveData
import com.svapp.coroutinessandbox.data.ResultListener
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.data.network.Api

/**
 * Created by Valentyn on 13.01.2019.
 */
class ContributorsRepositoryImpl(private val api: Api) : ContributorsRepository {

    override fun getRepoContributors(resultListener: ResultListener<LiveData<List<Contributor>>>) {

    }

    override fun getUserByLogin(resultListener: ResultListener<LiveData<Contributor>>) {

    }
}