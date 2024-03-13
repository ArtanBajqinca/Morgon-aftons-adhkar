package artan.bajqinca.morgon_afton_dhikr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.views.StartScreen
import artan.bajqinca.morgon_afton_dhikr.views.MorgonScreen
import artan.bajqinca.morgon_afton_dhikr.views.AftonScreen
import artan.bajqinca.morgon_afton_dhikr.views.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.StartScreen.route) {
            StartScreen(
                navController
            )

        }

        composable(route = Screen.MorgonScreen.route) {
            MorgonScreen(
                navController
            )
        }

        composable(route = Screen.AftonScreen.route) {
            AftonScreen(
                navController
            )
        }

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(
                navController
            )
        }
    }
}




