package com.example.recipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    init {
        fetchCategories()
    }




    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val responce = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = responce.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error("Error fetching Categories: ${e.message}")
                )

            }
        }
    }

    data class RecipeState(
        val loading: Boolean= true,
        val list: List<Category> = emptyList(),
        val error: String? = null
        )



}