package com.adoyo.errorhandlingclass.presentation

import com.adoyo.errorhandlingclass.R
import com.adoyo.errorhandlingclass.domain.DataError
import com.adoyo.errorhandlingclass.domain.Result

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.NetworkError.REQUEST_TIMEOUT -> UiText.StringResources(
            R.string.the_request_timed_out
        )

        DataError.Local.DATABASE_ERROR -> UiText.StringResources(R.string.database_error)
        DataError.Local.FILE_NOT_FOUND -> UiText.StringResources(R.string.file_not_found)
        DataError.Local.FILE_READ_ERROR -> UiText.StringResources(R.string.file_read_error)
        DataError.Local.FILE_WRITE_ERROR -> UiText.StringResources(R.string.file_write_error)
        DataError.Local.FILE_DELETE_ERROR -> UiText.StringResources(R.string.file_delete_error)
        DataError.NetworkError.TOO_MANY_REQUESTS -> UiText.StringResources(R.string.too_many_requests)
        DataError.NetworkError.NO_INTERNET_CONNECTION -> UiText.StringResources(R.string.no_internet_connection)
        DataError.NetworkError.UNKNOWN_HOST -> UiText.StringResources(R.string.unknown_host)
        DataError.NetworkError.UNAUTHORIZED -> UiText.StringResources(R.string.unauthorized)
        DataError.NetworkError.FORBIDDEN -> UiText.StringResources(R.string.forbidden)
        DataError.NetworkError.NOT_FOUND -> UiText.StringResources(R.string.not_found)
        DataError.NetworkError.BAD_REQUEST -> UiText.StringResources(R.string.bad_request)
    }
}

fun Result.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}