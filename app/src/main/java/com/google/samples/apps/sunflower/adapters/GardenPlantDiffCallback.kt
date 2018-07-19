
package com.google.samples.apps.sunflower.adapters

import android.support.v7.util.DiffUtil
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings

class GardenPlantDiffCallback : DiffUtil.ItemCallback<PlantAndGardenPlantings>() {

    override fun areItemsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant?.plantId == newItem.plant?.plantId
    }

    override fun areContentsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant == newItem.plant
    }
}