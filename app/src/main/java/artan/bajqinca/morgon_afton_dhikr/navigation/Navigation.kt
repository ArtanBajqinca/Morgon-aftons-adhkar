package artan.bajqinca.morgon_afton_dhikr.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel
import artan.bajqinca.morgon_afton_dhikr.views.StartScreen
import artan.bajqinca.morgon_afton_dhikr.views.MorgonScreen
import artan.bajqinca.morgon_afton_dhikr.views.AftonScreen
import artan.bajqinca.morgon_afton_dhikr.views.InfoScreen
import artan.bajqinca.morgon_afton_dhikr.views.RewardScreen
import artan.bajqinca.morgon_afton_dhikr.views.SplashScreen
import artan.bajqinca.morgon_afton_dhikr.views.TimesScreen

@Composable
fun Navigation(viewModel: TextOptionsViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = ScreenRoutes.SplashScreen.route,
    ) {

        composable(route = ScreenRoutes.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = ScreenRoutes.MorgonScreen.route) {
            MorgonScreen(navController, viewModel)
        }
        composable(route = ScreenRoutes.AftonScreen.route) {
            AftonScreen(navController, viewModel)
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
        composable(route = ScreenRoutes.InfoScreen.route) {
            InfoScreen(navController)
        }
    }
}




