package artan.bajqinca.morgon_afton_dhikr.main

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.navigation.Navigation
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes
import artan.bajqinca.morgon_afton_dhikr.viewModel.SplashViewModel
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private lateinit var textOptionsViewModel: TextOptionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textOptionsViewModel = TextOptionsViewModel(this)

        installSplashScreen().apply {
            setKeepOnScreenCondition { !splashViewModel.navigateToStartScreen.value }
        }

        splashViewModel.startDelay()

        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Navigation(textOptionsViewModel)
            }
        }
    }
}