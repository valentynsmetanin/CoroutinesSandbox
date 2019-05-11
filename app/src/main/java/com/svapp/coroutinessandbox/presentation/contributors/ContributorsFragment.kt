package com.svapp.coroutinessandbox.presentation.contributors

import androidx.lifecycle.Observer
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.databinding.FragmentContributorsBinding
import com.svapp.coroutinessandbox.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorsFragment : BaseFragment<FragmentContributorsBinding>() {

    private val mViewModel: ContributorsViewModel by viewModel()

    override fun getLayoutResId(): Int = R.layout.fragment_contributors

    override fun setupViews() {
        val adapter = ContributorsAdapter()
        binding.contributorsRecyclerView.adapter = adapter
        mViewModel.contributorsLiveData.observe(this,
            Observer<List<Contributor>> { t -> setContributors(t) }
        )
    }

    private fun setContributors(contributors: List<Contributor>) {
        binding.contributors = contributors
    }

}