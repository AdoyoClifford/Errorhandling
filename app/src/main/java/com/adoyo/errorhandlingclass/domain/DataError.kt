package com.adoyo.errorhandlingclass.domain

sealed interface DataError: Error {
    enum class NetworkError: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET_CONNECTION,
        UNKNOWN_HOST,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        BAD_REQUEST,
    }
    enum class Local: DataError {
        DATABASE_ERROR,
        FILE_NOT_FOUND,
        FILE_READ_ERROR,
        FILE_WRITE_ERROR,
        FILE_DELETE_ERROR,
    }
}