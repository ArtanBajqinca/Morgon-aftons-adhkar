package artan.bajqinca.morgon_afton_dhikr.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.views.StartScreen
import artan.bajqinca.morgon_afton_dhikr.views.MorgonScreen
import artan.bajqinca.morgon_afton_dhikr.views.AftonScreen
import artan.bajqinca.morgon_afton_dhikr.views.RewardScreen
import artan.bajqinca.morgon_afton_dhikr.views.SplashScreen
import artan.bajqinca.morgon_afton_dhikr.views.TimesScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = ScreenRoutes.AftonScreen.route,
    ) {

        composable(route = ScreenRoutes.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = ScreenRoutes.MorgonScreen.route) {
            MorgonScreen(navController)
        }
        composable(route = ScreenRoutes.AftonScreen.route) {
            AftonScreen(navController)
        }
        composable(route = ScreenRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = ScreenRoutes.TimesScreen.route) {
            TimesScreen(navController)
        }
        composable(route = ScreenRoutes.RewardScreen.route) {
            RewardScreen(navController)
        }
    }
}




