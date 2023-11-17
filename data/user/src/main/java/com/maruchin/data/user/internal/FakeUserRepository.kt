package com.maruchin.data.user.internal

import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import com.maruchin.data.user.sampleLoggedUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeUserRepository @Inject constructor() : UserRepository {

    private val user = MutableStateFlow<User>(User.LoggedOut)

    override fun get(): Flow<User> {
        return user
    }

    override suspend fun login(email: String, password: String) {
        user.emit(sampleLoggedUser)
    }

    override suspend fun register(
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String,
        password: String
    ) {
        user.emit(sampleLoggedUser)
    }

    override suspend fun logout() {
        user.emit(User.LoggedOut)
    }

    override suspend fun changePasswordWithToken(newPassword: String, token: String) = Unit

    override suspend fun changePassword(currentPassword: String, newPassword: String) = Unit

    override suspend fun deleteAccount() {
        user.emit(User.LoggedOut)
    }

    override suspend fun updatePersonalData(
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String
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