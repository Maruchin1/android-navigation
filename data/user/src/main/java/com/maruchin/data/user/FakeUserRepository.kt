package com.maruchin.data.user

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeUserRepository @Inject constructor() : UserRepository {

    private val user = MutableStateFlow<User>(sampleLoggedUser)

    override fun get(): Flow<User> {
        return user
    }

    override suspend fun login(email: Email, password: Password) {
        delay(1_000)
        user.emit(sampleLoggedUser)
    }

    override suspend fun register(
        firstName: String,
        lastName: String,
        email: Email,
        phoneNumber: PhoneNumber,
        password: Password
    ) {
        user.emit(sampleLoggedUser)
    }

    override suspend fun logout() {
        delay(1_000)
        user.emit(User.LoggedOut)
    }

    override suspend fun changePassword(newPassword: Password, token: Token) {
        delay(1_000)
    }

    override suspend fun changePassword(currentPassword: Password, newPassword: Password) {
        delay(1_000)
    }

    override suspend fun deleteAccount() {
        delay(1_000)
        user.emit(User.LoggedOut)
    }

    override suspend fun updatePersonalData(
        firstName: String,
        lastName: String,
        email: Email,
        phoneNumber: PhoneNumber
    ) {
        val loggedUser = user.value as? User.LoggedIn ?: return
        user.value = loggedUser.copy(
            firstName = firstName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber
        )
    }
}