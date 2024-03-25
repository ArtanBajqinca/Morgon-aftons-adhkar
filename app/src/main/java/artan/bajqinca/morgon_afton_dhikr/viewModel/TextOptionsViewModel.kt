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
        showArabic = visible
    }

    fun setTransliterationVisibility(visible: Boolean) {
        showTransliteration = visible
    }

    fun setTranslationVisibility(visible: Boolean) {
        showTranslation = visible
    }

}