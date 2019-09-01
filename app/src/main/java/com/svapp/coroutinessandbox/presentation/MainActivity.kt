package com.svapp.coroutinessandbox.presentation

import androidx.appcompat.widget.Toolbar
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun prepareActionBar() {
        (includedToolbar as? Toolbar)?.let {
            setSupportActionBar(it)
        }
    }
}
