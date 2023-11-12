package com.maruchin.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun get(): Flow<User>

    suspend fun login(email: Email, password: Password)

    suspend fun logout()

    suspend fun changePassword(newPassword: Password, token: Token)

    suspend fun changePassword(currentPassword: Password, newPassword: Password)

    suspend fun deleteAccount()

    suspend fun updatePersonalData(
        firstName: String,
        lastName: String,
        email: Email,
        phoneNumber: PhoneNumber,
    )
}