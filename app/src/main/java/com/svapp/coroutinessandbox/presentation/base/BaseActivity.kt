package com.svapp.coroutinessandbox.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Valentyn on 13.01.2019.
 */
abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    protected abstract fun prepareActionBar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutResId() != NONE) {
            setContentView(getLayoutResId())
            prepareActionBar()
        }
    }

    companion object {
        const val NONE = -1
    }

}