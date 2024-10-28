package com.adoyo.errorhandlingclass.domain

class AuthRepository {
    suspend fun register(password: String): Result<User, DataError.NetworkError>{}
}

data class User(val fullName: String, val email: String, val token: String)