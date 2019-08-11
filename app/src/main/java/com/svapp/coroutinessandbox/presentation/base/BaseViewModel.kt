package com.svapp.coroutinessandbox.presentation.base

import androidx.lifecycle.ViewModel
import com.svapp.coroutinessandbox.data.ResultListener

abstract class BaseViewModel : ViewModel() {

    fun <T : Any> ResultListener<T>.handleResult(
        onLoading: (Boolean) -> Unit = this@BaseViewModel::handleLoading,
        onError: (throwable: Throwable) -> Unit = this@BaseViewModel::handleError,
        onSuccess: (T) -> Unit
    ) {
        when (this) {
            is ResultListener.Success<T> -> onSuccess(result)
            is ResultListener.Loading -> onLoading(isLoading)
            is ResultListener.Error -> onError(throwable)
        }
    }

    protected open fun handleError(throwable: Throwable) {
    }

    protected open fun handleLoading(isLoading: Boolean) {
    }
}