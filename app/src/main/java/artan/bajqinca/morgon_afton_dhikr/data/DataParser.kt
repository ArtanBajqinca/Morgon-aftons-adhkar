import android.content.Context
import android.util.Log
import artan.bajqinca.morgon_afton_dhikr.model.AdkarModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DataParser(private val context: Context) {

    fun getMorningAdhkarList(): List<AdkarModel> {
        return parseJsonData("AdhkarMorgon.json")
    }

    private fun parseJsonData(filename: String): List<AdkarModel> {
        val jsonFileString = getJsonDataFromAsset(filename)
        val gson = Gson()
        val listType = object : TypeToken<List<AdkarModel>>() {}.type
        return gson.fromJson(jsonFileString, listType)
    }

    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("DataParser", "getJsonDataFromAsset: ERROR", ioException)
            return "[]"
        }
        return jsonString
    }
}
