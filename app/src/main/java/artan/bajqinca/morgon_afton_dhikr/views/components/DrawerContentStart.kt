package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContentStart(
    navController: NavController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {
    ModalDrawerSheet(
        drawerShape = RectangleShape,
    ) {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.dark_beige))
        ) {
            Box (
                modifier = Modifier
                    .width(240.dp)
                    .fillMaxHeight()
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.settings_bg),
                    contentDescription = "Settings Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .width(240.dp)
                ) {
                    Spacer(modifier = Modifier.height(65.dp))
                    Image(
                        painter = painterResource(id = R.drawable.morgon_afton_logo),
                        contentDescription = "Morgon Afton Logo",
                        modifier = Modifier
                            .width(126.dp)
                            .align(Alignment.CenterHorizontally) // Center the logo
                    )
                    Text(
                        text = "Version 1.0",
                        color = colorResource(id = R.color.light_beige),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(47.dp))

                    StartSettingsButton(
                        buttonText = "Tiderna för morgon & afton",
                        settingsIcon = R.drawable.time_icon,
                        buttonBackgroundColor = R.color.light_orange,
                        onClick = {
                            coroutineScope.launch {
                                navController.navigate(ScreenRoutes.TimesScreen.route)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    StartSettingsButton(
                        buttonText = "Fördelarna med adhkar",
                        settingsIcon = R.drawable.hand_star_icon,
                        buttonBackgroundColor = R.color.blue,
                        onClick = {
                            coroutineScope.launch {
                                navController.navigate(ScreenRoutes.RewardScreen.route)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(190.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ayah_graphic),
                        contentDescription = "Ayah Graphic",
                        modifier = Modifier
                            .width(154.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(100.dp))
                    Text(
                        text = "Skyddad av upphovsrätten ©",
                        color = colorResource(id = R.color.light_beige),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 11.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp)
                    )
                }
            }
        }
    }
}