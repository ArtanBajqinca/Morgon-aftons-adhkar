package artan.bajqinca.morgon_afton_dhikr.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import artan.bajqinca.morgon_afton_dhikr.navigation.Navigation
import artan.bajqinca.morgon_afton_dhikr.viewModel.AdhkarViewModel
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel

class MainActivity : ComponentActivity() {

    private val adhkarViewModel: AdhkarViewModel by viewModels()

    private lateinit var textOptionsViewModel: TextOptionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        textOptionsViewModel = TextOptionsViewModel(this)

        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Navigation(textOptionsViewModel, adhkarViewModel)
            }
        }
    }
}
