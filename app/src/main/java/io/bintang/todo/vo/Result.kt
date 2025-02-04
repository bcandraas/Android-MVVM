package io.bintang.todo.vo

data class Result<out T>(val status: Status, val data: T?, val message: String?, val httpCode : Int = 0) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(httpCode : Int, message: String, data: T? = null): Result<T> {
            return Result(Status.ERROR, data, message, httpCode)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }
    }
}