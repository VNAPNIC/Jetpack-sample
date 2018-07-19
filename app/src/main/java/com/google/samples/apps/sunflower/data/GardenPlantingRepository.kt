
package com.google.samples.apps.sunflower.data

import com.google.samples.apps.sunflower.utilities.runOnIoThread

class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {

    fun createGardenPlanting(plantId: String) {
        runOnIoThread {
            val gardenPlanting = GardenPlanting(plantId)
            gardenPlantingDao.insertGardenPlanting(gardenPlanting)
        }
    }

    fun getGardenPlantingForPlant(plantId: String) =
            gardenPlantingDao.getGardenPlantingForPlant(plantId)

    fun getGardenPlantings() = gardenPlantingDao.getGardenPlantings()

    fun getPlantAndGardenPlantings() = gardenPlantingDao.getPlantAndGardenPlantings()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
                instance ?: synchronized(this) {
                    instance ?: GardenPlantingRepository(gardenPlantingDao).also { instance = it }
                }
    }
}