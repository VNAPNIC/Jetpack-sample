
package com.google.samples.apps.sunflower.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name = "id") val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7, // how often the plant should be watered, in days
    val imageUrl: String = ""
) {

    /**
     * Determines if the plant should be watered.  Returns true if today's date > date of last
     * watering + watering Interval; false otherwise.
     */
    fun shouldBeWatered(lastWateringDate: Calendar) =
            Calendar.getInstance() > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name
}
