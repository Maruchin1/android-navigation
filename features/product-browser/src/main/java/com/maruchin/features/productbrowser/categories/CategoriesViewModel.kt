package com.maruchin.features.productbrowser.categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.categories.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CategoriesViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
) : ViewModel() {

    var categories by mutableStateOf<List<Category>>(emptyList())
        private set

    init {
        loadCategories()
    }

    private fun loadCategories() = viewModelScope.launch {
        categories = categoriesRepository.getAll()
    }
}