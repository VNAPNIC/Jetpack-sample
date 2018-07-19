
package com.google.samples.apps.sunflower.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.google.samples.apps.sunflower.data.PlantRepository

/**
 * Factory for creating a [PlantListViewModel] with a constructor that takes a [PlantRepository].
 */
class PlantListViewModelFactory(
    private val repository: PlantRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PlantListViewModel(repository) as T
}
