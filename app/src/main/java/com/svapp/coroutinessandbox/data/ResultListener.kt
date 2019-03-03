package com.svapp.coroutinessandbox.data

/**
 * Created by Valentyn on 13.01.2019.
 */
interface ResultListener<T: Any> {

    fun onResult(result: T?)

    fun onError(error: Throwable?)

}