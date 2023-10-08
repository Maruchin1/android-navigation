package com.maruchin.features.productcard.gallery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.URL
import javax.inject.Inject

@HiltViewModel
internal class GalleryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    private val args = GalleryArgs(savedStateHandle)

    var images by mutableStateOf<List<URL>>(emptyList())
        private set

    init {
        loadImages()
    }

    private fun loadImages() = viewModelScope.launch {
        val product = productsRepository.getById(args.productId)
        images = product.images
    }
}