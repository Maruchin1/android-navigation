package com.maruchin.features.categorybrowser.categorylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class CategoryListViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
) : ViewModel() {

    val categories = flow { emit(categoriesRepository.getAll()) }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}