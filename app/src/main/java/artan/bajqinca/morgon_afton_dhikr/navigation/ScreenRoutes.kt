package artan.bajqinca.morgon_afton_dhikr.navigation

sealed class ScreenRoutes(val route: String){
    object SplashScreen: ScreenRoutes( "splash_screen")
    object StartScreen: ScreenRoutes("home_screen")
    object MorgonScreen: ScreenRoutes("morgon_screen")
    object AftonScreen: ScreenRoutes("afton_screen")
}
