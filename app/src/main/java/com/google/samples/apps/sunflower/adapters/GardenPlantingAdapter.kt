
package com.google.samples.apps.sunflower.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings
import com.google.samples.apps.sunflower.databinding.ListItemGardenPlantingBinding
import com.google.samples.apps.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

class GardenPlantingAdapter(
    val context: Context
) : ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder>(GardenPlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_garden_planting, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { plantings ->
            with(holder) {
                itemView.tag = plantings
                bind(plantings)
            }
        }
    }

    class ViewHolder(
        private val binding: ListItemGardenPlantingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(
                    itemView.context,
                    plantings
                )
                executePendingBindings()
            }
        }
    }
}