package com.android.rebtelflags.data.model

/**
 *  Since Retrofit classes use 'Response' as a wrapper class, we need a generic wrapper classes to hold
 *  result regardless of the data source.
 */
data class Result<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String): Result<T> {
            return Result(Status.ERROR, null, message)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, message=$message)"
    }
}