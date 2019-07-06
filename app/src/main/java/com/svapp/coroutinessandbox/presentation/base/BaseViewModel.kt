package com.svapp.coroutinessandbox.presentation.base

import androidx.lifecycle.ViewModel
import com.svapp.coroutinessandbox.data.GeneralCauseError
import com.svapp.coroutinessandbox.data.ResultObject

abstract class BaseViewModel : ViewModel() {

    fun <T> ResultObject<T>.handleResult(
        onSuccess: (T) -> Unit,
        onError: (cause: GeneralCauseError) -> Unit = this@BaseViewModel::handleErrorResult
    ) {
        when (this) {
            is ResultObject.Success -> onSuccess(data)
            is ResultObject.Error -> onError(cause)
        }
    }

    protected open fun handleErrorResult(cause: GeneralCauseError) {
    }
}