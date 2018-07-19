
package com.google.samples.apps.sunflower.adapters

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.samples.apps.sunflower.PlantListFragment
import com.google.samples.apps.sunflower.PlantListFragmentDirections
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.databinding.ListItemPlantBinding

/**
 * Adapter for the [RecyclerView] in [PlantListFragment].
 */
class PlantAdapter : ListAdapter<Plant, PlantAdapter.ViewHolder>(PlantDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plant = getItem(position)
        holder.apply {
            bind(createOnClickListener(plant.plantId), plant)
            itemView.tag = plant
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemPlantBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(plantId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment(plantId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemPlantBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Plant) {
            binding.apply {
                clickListener = listener
                plant = item
                executePendingBindings()
            }
        }
    }
}