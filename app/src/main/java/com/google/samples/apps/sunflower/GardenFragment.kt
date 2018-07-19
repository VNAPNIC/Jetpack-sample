
package com.google.samples.apps.sunflower

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.samples.apps.sunflower.adapters.GardenPlantingAdapter
import com.google.samples.apps.sunflower.utilities.InjectorUtils
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModel

class GardenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_garden, container, false)
        val adapter = GardenPlantingAdapter(view.context)
        view.findViewById<RecyclerView>(R.id.garden_list).adapter = adapter
        subscribeUi(adapter)
        return view
    }

    private fun subscribeUi(adapter: GardenPlantingAdapter) {
        val factory = InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
        val viewModel = ViewModelProviders.of(this, factory)
                .get(GardenPlantingListViewModel::class.java)

        viewModel.gardenPlantings.observe(viewLifecycleOwner, Observer { plantings ->
            if (plantings != null && plantings.isNotEmpty()) {
                activity?.run {
                    findViewById<RecyclerView>(R.id.garden_list).run { visibility = View.VISIBLE }
                    findViewById<TextView>(R.id.empty_garden).run { visibility = View.GONE }
                }
            } else {
                activity?.run {
                    findViewById<RecyclerView>(R.id.garden_list).run { visibility = View.GONE }
                    findViewById<TextView>(R.id.empty_garden).run { visibility = View.VISIBLE }
                }
            }
        })

        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner, Observer { result ->
            if (result != null && result.isNotEmpty())
                adapter.submitList(result)
        })
    }
}
