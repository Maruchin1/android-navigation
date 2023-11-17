package com.maruchin.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.products.ProductsRepository
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val products = categoriesRepository.getRecommended()
        .flatMapLatest { categories ->
            val products = categories.map { category ->
                productsRepository.getRecommendedForCategory(category.id)
                    .map { category to it }
            }
            combine(products) { it.toMap() }
        }
    private val canLogin = userRepository.get().map { it is User.LoggedOut }

    val uiState = combine(products, canLogin, ::createHomeUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, HomeUiState())
}