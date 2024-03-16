package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes
import artan.bajqinca.morgon_afton_dhikr.views.components.DrawerContentStart
import artan.bajqinca.morgon_afton_dhikr.views.components.ImageBtn
import artan.bajqinca.morgon_afton_dhikr.views.components.StartSettingsTab

@Composable
fun StartScreen(navController: NavController = rememberNavController()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContentStart(navController, drawerState, coroutineScope)
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

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}
