package com.adoyo.errorhandlingclass.data

import com.adoyo.errorhandlingclass.domain.AuthRepository
import com.adoyo.errorhandlingclass.domain.DataError
import com.adoyo.errorhandlingclass.domain.Result
import com.adoyo.errorhandlingclass.domain.User
import retrofit2.HttpException

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(password: String): Result<User, DataError.NetworkError> {
        return try {
            val user = User("John Doe", "dummy", "dummy")
            return Result.Success(user)

        } catch (e: HttpException) {
            when (e.code()) {
                400 -> Result.Error(DataError.NetworkError.BAD_REQUEST)
                401 -> Result.Error(DataError.NetworkError.UNAUTHORIZED)
                403 -> Result.Error(DataError.NetworkError.FORBIDDEN)
                404 -> Result.Error(DataError.NetworkError.NOT_FOUND)
                429 -> Result.Error(DataError.NetworkError.TOO_MANY_REQUESTS)
                else -> Result.Error(DataError.NetworkError.UNKNOWN_HOST)
            }
        }
    }
}