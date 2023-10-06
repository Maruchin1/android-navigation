package com.maruchin.androidnavigation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class KtorModule {

    @Provides
    @Singleton
    fun client() = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url("https://fakestoreapi.com")
        }
    }
}