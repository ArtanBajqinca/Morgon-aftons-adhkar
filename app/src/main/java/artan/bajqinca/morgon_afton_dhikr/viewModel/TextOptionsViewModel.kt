package artan.bajqinca.morgon_afton_dhikr.viewModel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TextOptionsViewModel(context: Context) : ViewModel() {
    var showArabic by mutableStateOf(true)
        private set
    var showTransliteration by mutableStateOf(true)
        private set
    var showTranslation by mutableStateOf(true)
        private set

    init {
        loadSettings(context)
    }

    fun setArabicVisibility(visible: Boolean, context: Context) {
        val canHide = showTransliteration || showTranslation
        showArabic = visible || !canHide
        saveSettings(context)
    }

    fun setTransliterationVisibility(visible: Boolean, context: Context) {
        val canHide = showArabic || showTranslation
        showTransliteration = visible || !canHide
        saveSettings(context)
    }

    fun setTranslationVisibility(visible: Boolean, context: Context) {
        val canHide = showArabic || showTransliteration
        showTranslation = visible || !canHide
        saveSettings(context)
    }

    private fun saveSettings(context: Context) {
        // Save settings to shared preferences
        val sharedPref = context.getSharedPreferences("textOptionsSettings", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean("showArabic", showArabic)
            putBoolean("showTransliteration", showTransliteration)
            putBoolean("showTranslation", showTranslation)
            apply()
        }
    }

    private fun loadSettings(context: Context) {
        // Load settings from shared preferences
        val sharedPref = context.getSharedPreferences("textOptionsSettings", Context.MODE_PRIVATE)
        showArabic = sharedPref.getBoolean("showArabic", true)
        showTransliteration = sharedPref.getBoolean("showTransliteration", true)
        showTranslation = sharedPref.getBoolean("showTranslation", true)
    }
}