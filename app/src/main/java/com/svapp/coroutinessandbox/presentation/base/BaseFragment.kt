package com.svapp.coroutinessandbox.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by Valentyn on 13.01.2019.
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var binding: T

    @LayoutRes
    abstract fun getLayoutResId() : Int

    abstract fun setupViews()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutResId(), container, false)
        setupViews()
        return binding.root
    }

    fun setTitle(@StringRes resId: Int) {
        (activity as? BaseActivity)?.supportActionBar?.setTitle(resId)
    }

}