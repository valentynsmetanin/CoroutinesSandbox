package com.svapp.coroutinessandbox.presentation.contributors

import androidx.navigation.findNavController
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.data.model.Contributor
import com.svapp.coroutinessandbox.databinding.FragmentContributorsBinding
import com.svapp.coroutinessandbox.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorsFragment : BaseFragment<FragmentContributorsBinding>(), ContributorsAdapter.ContributorClickListener {

    private val mViewModel: ContributorsViewModel by viewModel()

    override fun getLayoutResId() = R.layout.fragment_contributors

    override fun setupViews() {
        with(binding) {
            contributorsRecyclerView.adapter = ContributorsAdapter(this@ContributorsFragment)
            viewModel = mViewModel
            lifecycleOwner = this@ContributorsFragment.viewLifecycleOwner
        }
    }

    override fun onContributorClick(contributor: Contributor) {
        val direction = ContributorsFragmentDirections.actionContributorsListFragmentToContributorDetailsFragment(contributor.login ?: "")
        view?.findNavController()?.navigate(direction)
    }

}