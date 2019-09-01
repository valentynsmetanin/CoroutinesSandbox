package com.svapp.coroutinessandbox.presentation

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.svapp.coroutinessandbox.R
import com.svapp.coroutinessandbox.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val mNavController by lazy { findNavController(this, R.id.nav_host_fragment) }

    override fun getLayoutResId() = R.layout.activity_main

    override fun prepareActionBar() {
        (includedToolbar as? Toolbar)?.let {
            setSupportActionBar(it)
        }
        NavigationUI.setupActionBarWithNavController(this, mNavController)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            mNavController.popBackStack()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
