package com.adoyo.errorhandlingclass.presentation

import com.adoyo.errorhandlingclass.R
import com.adoyo.errorhandlingclass.domain.DataError

fun DataError.asUiText(): UiText {
    return when(this) {
        DataError.NetworkError.REQUEST_TIMEOUT -> UiText.StringResources(
            R.string.the_request_timed_out
        )
        DataError.Local.DATABASE_ERROR -> UiText.StringResources(R.string)
        DataError.Local.FILE_NOT_FOUND -> TODO()
        DataError.Local.FILE_READ_ERROR -> TODO()
        DataError.Local.FILE_WRITE_ERROR -> TODO()
        DataError.Local.FILE_DELETE_ERROR -> TODO()
        DataError.NetworkError.TOO_MANY_REQUESTS -> TODO()
        DataError.NetworkError.NO_INTERNET_CONNECTION -> TODO()
        DataError.NetworkError.UNKNOWN_HOST -> TODO()
        DataError.NetworkError.UNAUTHORIZED -> TODO()
        DataError.NetworkError.FORBIDDEN -> TODO()
        DataError.NetworkError.NOT_FOUND -> TODO()
        DataError.NetworkError.BAD_REQUEST -> TODO()
    }
}