package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes
import artan.bajqinca.morgon_afton_dhikr.views.components.ImageBtn
import artan.bajqinca.morgon_afton_dhikr.views.components.StartSettingsTab
import kotlinx.coroutines.CoroutineScope

@Composable
fun StartScreen(navController: NavController = rememberNavController()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController, drawerState, coroutineScope)
        }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFFBE741A)),
                contentAlignment = Alignment.Center
            ) {
                ImageBtn(
                    image = R.drawable.morgon_image_btn,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                            navController.navigate(ScreenRoutes.MorgonScreen.route)
                        }
                    }
                )
                StartSettingsTab {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.blue)),
                contentAlignment = Alignment.Center
            ) {
                ImageBtn(
                    image = R.drawable.afton_image_btn,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                            navController.navigate(ScreenRoutes.AftonScreen.route)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun DrawerContent(
    navController: NavController,
    drawerState: DrawerState,
    coroutineScope: CoroutineScope
) {
    ModalDrawerSheet {
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
                        .fillMaxHeight()
                        .width(240.dp),
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
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}
