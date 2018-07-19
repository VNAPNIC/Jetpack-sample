
package com.google.samples.apps.sunflower.data

import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class PlantAndGardenPlantingTest {

    @Test fun test_default_values() {
        val p = PlantAndGardenPlantings()
        assertNull(p.plant)
        assertTrue(p.gardenPlantings.isEmpty())
    }
}