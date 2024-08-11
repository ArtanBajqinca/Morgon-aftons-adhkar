package artan.bajqinca.morgon_afton_dhikr.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import artan.bajqinca.morgon_afton_dhikr.model.AdkarModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.reflect.Type

class AdhkarViewModel(application: Application) : AndroidViewModel(application) {

    private val gson: Gson by lazy { Gson() }

    var morningAdhkarList: List<AdkarModel> = emptyList()
        private set

    var eveningAdhkarList: List<AdkarModel> = emptyList()
        private set

    init {
        viewModelScope.launch {
            morningAdhkarList = parseJsonData("adhkar_morgon.json")
            eveningAdhkarList = parseJsonData("adhkar_afton.json")
        }
    }

    private inline fun <reified T> parseJsonData(filename: String): T {
        val jsonFileString = getJsonDataFromAsset(filename) ?: return emptyList<T>() as T
        val type: Type = object : TypeToken<T>() {}.type
        return gson.fromJson(jsonFileString, type)
    }

    private fun getJsonDataFromAsset(fileName: String): String? {
        return try {
            getApplication<Application>().assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("AdhkarViewModel", "Error reading from $fileName", ioException)
            null
        }
    }
}
