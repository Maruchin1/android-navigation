package com.maruchin.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun get(): Flow<User>

    suspend fun login(email: Email, password: Password)

    suspend fun logout()
}