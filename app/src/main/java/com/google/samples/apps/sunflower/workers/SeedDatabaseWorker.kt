
package com.google.samples.apps.sunflower.workers

import android.util.Log
import androidx.work.Worker
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.utilities.PLANT_DATA_FILENAME

class SeedDatabaseWorker : Worker() {
    private val TAG = SeedDatabaseWorker::class.java.simpleName

    override fun doWork(): Worker.Result {
        val plantType = object : TypeToken<List<Plant>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(PLANT_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
            val database = AppDatabase.getInstance(applicationContext)
            database.plantDao().insertAll(plantList)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }
}