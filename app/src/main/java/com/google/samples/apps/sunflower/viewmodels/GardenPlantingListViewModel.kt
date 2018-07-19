
package com.google.samples.apps.sunflower.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings

class GardenPlantingListViewModel internal constructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {

    val gardenPlantings = gardenPlantingRepository.getGardenPlantings()

    val plantAndGardenPlantings: LiveData<List<PlantAndGardenPlantings>> =
            Transformations.map(gardenPlantingRepository.getPlantAndGardenPlantings()) {
                it.filter { it.gardenPlantings.isNotEmpty() }
            }
}