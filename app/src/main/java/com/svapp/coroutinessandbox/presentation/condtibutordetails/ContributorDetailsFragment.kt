package com.svapp.coroutinessandbox.presentation.condtibutordetails

import androidx.navigation.fragment.navArgs
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.databinding.FragmentContributorDetailsBinding
import com.svapp.coroutinessandbox.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorDetailsFragment : BaseFragment<FragmentContributorDetailsBinding>() {

    private val mViewModel: ContributorDetailsViewModel by viewModel()
    private val args: ContributorDetailsFragmentArgs by navArgs()

    override fun getLayoutResId() = R.layout.fragment_contributor_details

    override fun setupViews() {
        with(binding) {
            lifecycleOwner = this@ContributorDetailsFragment.viewLifecycleOwner
            viewModel = mViewModel
        }
        startViewModel()
    }

    private fun startViewModel() {
        args.argLogin.let {
            mViewModel.start(it)
        }
    }

}