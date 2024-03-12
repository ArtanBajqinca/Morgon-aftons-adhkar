package artan.bajqinca.morgon_afton_dhikr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.screens.StartScreen
import artan.bajqinca.morgon_afton_dhikr.screens.MorgonScreen
import artan.bajqinca.morgon_afton_dhikr.screens.AftonScreen
import artan.bajqinca.morgon_afton_dhikr.screens.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StartScreen.route) {
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
    }
}




