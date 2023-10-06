package com.maruchin.androidnavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.lifecycleScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.categories.Category
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var categoriesRepository: CategoriesRepository

    @Inject
    lateinit var productsRepository: ProductsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val categories = categoriesRepository.getAll()
            Log.d("MainActivity", categories.toString())
        }

        lifecycleScope.launch {
            val products = productsRepository.getForCategory(Category("electronics"))
            Log.d("MainActivity", products.toString())
        }

        setContent {
            MaterialTheme {
            }
        }
    }
}
