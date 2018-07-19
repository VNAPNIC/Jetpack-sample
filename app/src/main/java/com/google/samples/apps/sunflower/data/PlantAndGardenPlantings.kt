
package com.google.samples.apps.sunflower.data

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

/**
 * This class captures the relationship between a [Plant] and a user's [GardenPlanting], which is
 * used by Room to fetch the related entities.
 */
class PlantAndGardenPlantings {

    @Embedded
    var plant: Plant? = null

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    var gardenPlantings: List<GardenPlanting> = arrayListOf()
}
