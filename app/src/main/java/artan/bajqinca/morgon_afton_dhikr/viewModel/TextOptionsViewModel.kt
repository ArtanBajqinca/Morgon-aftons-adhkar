package artan.bajqinca.morgon_afton_dhikr.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TextOptionsViewModel() : ViewModel() {
    var showArabic by mutableStateOf(true)
        private set
    var showTransliteration by mutableStateOf(true)
        private set
    var showTranslation by mutableStateOf(true)
        private set

    fun setArabicVisibility(visible: Boolean) {
        val canHide = showTransliteration || showTranslation
        showArabic = visible || !canHide
    }

    fun setTransliterationVisibility(visible: Boolean) {
        val canHide = showArabic || showTranslation
        showTransliteration = visible || !canHide
    }

    fun setTranslationVisibility(visible: Boolean) {
        val canHide = showArabic || showTransliteration
        showTranslation = visible || !canHide
    }

}