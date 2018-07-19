
package com.google.samples.apps.sunflower.viewmodels

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantRepository
import com.google.samples.apps.sunflower.utilities.getValue
import com.google.samples.apps.sunflower.utilities.testPlant
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

class PlantDetailViewModelTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var viewModel: PlantDetailViewModel

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        val plantRepo = PlantRepository.getInstance(appDatabase.plantDao())
        val gardenPlantingRepo = GardenPlantingRepository.getInstance(
                appDatabase.gardenPlantingDao())
        viewModel = PlantDetailViewModel(plantRepo, gardenPlantingRepo, testPlant.plantId)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() {
        assertFalse(getValue(viewModel.isPlanted))
    }
}