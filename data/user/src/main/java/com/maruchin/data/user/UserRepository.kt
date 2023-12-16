package com.maruchin.data.user

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface UserRepository {

    fun get(): Flow<User>

    suspend fun login(email: String, password: String)

    suspend fun register(personalData: PersonalData, password: String)

    suspend fun logout()

    suspend fun changePasswordWithToken(newPassword: String, token: String)

    suspend fun changePassword(currentPassword: String, newPassword: String)

    suspend fun deleteAccount()

    suspend fun updatePersonalData(personalData: PersonalData)

    suspend fun updateBirthDate(birthDate: LocalDate)
}