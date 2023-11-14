package com.maruchin.features.categorybrowser.subcategorylist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class SubcategoryListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val categoriesRepository: CategoriesRepository,
) : ViewModel() {

    private val args = SubcategoryListArgs(savedStateHandle)

    val uiState = categoriesRepository.getById(args.categoryId)
        .filterNotNull()
        .map(::createSubcategoryListUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, SubcategoryListUiState())
}