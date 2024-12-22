package com.example.ucp_2_b.ui.viewmodel


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp_2_b.TokoApp

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeBrgViewModel(
                tokoApp().containerApp.repositoryBarang
            )
        }
        initializer {
            InsertBrgViewModel(
                tokoApp().containerApp.repositoryBarang
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                tokoApp().containerApp.repositoryBarang
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                tokoApp().containerApp.repositoryBarang
            )
        }
        initializer {
            HomeSplViewModel(
                tokoApp().containerApp.repositorySuplier
            )
        }
        initializer {
            InsertSplViewModel(
                tokoApp().containerApp.repositorySuplier
            )
        }
    }
}

fun CreationExtras.tokoApp(): TokoApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TokoApp)