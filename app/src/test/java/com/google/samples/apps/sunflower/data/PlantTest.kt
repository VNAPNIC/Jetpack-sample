
package com.google.samples.apps.sunflower.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

class PlantTest {

    private lateinit var plant: Plant

    @Before fun setUp() {
        plant = Plant("1", "Tomato", "A red vegetable", 1, 2, "")
    }

    @Test fun test_default_values() {
        val defaultPlant = Plant("2", "Apple", "Description", 1)
        assertEquals(7, defaultPlant.wateringInterval)
        assertEquals("", defaultPlant.imageUrl)
    }

    @Test fun test_shouldBeWatered() {
        assertFalse(plant.shouldBeWatered(Calendar.getInstance()))
        assertFalse(plant.shouldBeWatered(Calendar.getInstance().apply { add(DAY_OF_YEAR, -1) }))
        assertFalse(plant.shouldBeWatered(Calendar.getInstance().apply { add(DAY_OF_YEAR, -2) }))
        assertTrue(plant.shouldBeWatered(Calendar.getInstance().apply { add(DAY_OF_YEAR, -3) }))
    }

    @Test fun test_toString() {
        assertEquals("Tomato", plant.toString())
    }
}