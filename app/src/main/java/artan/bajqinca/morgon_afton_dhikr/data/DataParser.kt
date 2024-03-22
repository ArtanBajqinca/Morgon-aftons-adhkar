import android.content.Context
import android.util.Log
import artan.bajqinca.morgon_afton_dhikr.model.AdkarModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.lang.reflect.Type

class DataParser(private val context: Context) {

    private val gson: Gson by lazy { Gson() }

    fun getMorningAdhkarList(): List<AdkarModel> = parseJsonData("adhkar_morgon.json")

    fun getEveningAdhkarList(): List<AdkarModel> = parseJsonData("adhkar_afton.json")

    private inline fun <reified T> parseJsonData(filename: String): T {
        val jsonFileString = getJsonDataFromAsset(filename) ?: return emptyList<T>() as T
        val type: Type = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonFileString, type)
    }

    private fun getJsonDataFromAsset(fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("DataParser", "Error reading from $fileName", ioException)
            null
        }
    }
}
