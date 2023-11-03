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

    override suspend fun logout() {
        delay(1_000)
        user.emit(User.LoggedOut)
    }

    override suspend fun changePassword(newPassword: Password, token: Token) {
        delay(1_000)
    }
}