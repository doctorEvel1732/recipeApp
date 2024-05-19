package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun RecipeScreen(modifier: Modifier = Modifier) {

    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier) {
        when {
            viewState.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error !=null ->{
                Text(text = "Error Occurred")
            }
            else ->{
                //Display Categories
            }
        }

    }




}