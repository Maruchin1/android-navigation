package com.maruchin.data.categories

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