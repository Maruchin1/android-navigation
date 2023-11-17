package com.maruchin.data.categories.internal

import com.maruchin.data.categories.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataCategoriesModule {

    @Binds
    fun categoriesRepository(impl: FakeCategoriesRepository): CategoriesRepository
}