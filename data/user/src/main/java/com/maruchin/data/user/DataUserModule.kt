package com.maruchin.data.user

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataUserModule {

    @Binds
    fun userRepository(impl: FakeUserRepository): UserRepository
}