package com.svapp.coroutinessandbox.data

/**
 * Created by Valentyn on 13.01.2019.
 */
sealed class ResultListener<out T : Any> {
    data class Success<out T : Any>(val result: T) : ResultListener<T>()
    data class Error(val throwable: Throwable) : ResultListener<Nothing>()
    data class Loading(val isLoading: Boolean) : ResultListener<Nothing>()
}