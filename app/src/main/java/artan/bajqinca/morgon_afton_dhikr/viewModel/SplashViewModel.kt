package artan.bajqinca.morgon_afton_dhikr.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _navigateToStartScreen = MutableStateFlow(false)
    val navigateToStartScreen = _navigateToStartScreen.asStateFlow()

    fun startDelay() {
        viewModelScope.launch {
            delay(1000) // Adjust the time as needed
            _navigateToStartScreen.value = true
        }
    }
}