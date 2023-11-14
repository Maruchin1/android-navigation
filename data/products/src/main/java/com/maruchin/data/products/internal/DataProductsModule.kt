package com.maruchin.data.products.internal

import com.maruchin.data.products.ProductFiltersRepository
import com.maruchin.data.products.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataProductsModule {

    @Binds
    fun productsRepository(impl: FakeProductsRepository): ProductsRepository

    @Binds
    fun productFiltersRepository(impl: FakeProductFiltersRepository): ProductFiltersRepository
}