package com.svapp.coroutinessandbox.presentation.condtibutordetails

import android.os.Bundle
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.databinding.FragmentContributorDetailsBinding
import com.svapp.coroutinessandbox.presentation.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Valentyn on 03.03.2019.
 */
class ContributorDetailsFragment : BaseFragment<FragmentContributorDetailsBinding>() {

    private val mViewModel: ContributorDetailsViewModel by viewModel()

    private var mLogin: String? = null

    override fun getLayoutResId() = R.layout.fragment_contributor_details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mLogin = it.getString("argLogin")
        }
    }

    override fun setupViews() {
        with(binding) {
            lifecycleOwner = this@ContributorDetailsFragment
            viewModel = mViewModel
        }
        startViewModel()
    }

    private fun startViewModel() {
        mLogin?.let {
            mViewModel.start(it)
        }
    }

}