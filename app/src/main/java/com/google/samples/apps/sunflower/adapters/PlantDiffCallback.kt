
package com.google.samples.apps.sunflower.adapters

import android.support.v7.util.DiffUtil
import com.google.samples.apps.sunflower.data.Plant

class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}