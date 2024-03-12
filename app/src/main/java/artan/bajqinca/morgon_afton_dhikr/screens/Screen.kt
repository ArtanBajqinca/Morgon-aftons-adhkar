package artan.bajqinca.morgon_afton_dhikr.screens

sealed class Screen(val route: String){

//    object SplashScreen: Screen( "splash_screen")
    object StartScreen: Screen("home_screen")
    object MorgonScreen: Screen("morgon_screen")
    object AftonScreen: Screen("afton_screen")
}
