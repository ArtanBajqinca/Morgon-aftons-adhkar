package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
            DrawerContentStart(
                navController = navController,
                drawerState = drawerState,
                coroutineScope = coroutineScope
            )
        }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFBE6001))
                    .padding(20.dp),
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
                Box(
                    modifier = Modifier
                        .zIndex(1f)
                        .offset {
                            IntOffset(-140, 200)
                        }
                        .align(Alignment.TopStart)
                ) {
                    StartSettingsTab {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(colorResource(id = R.color.blue))
                    .padding(20.dp),
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

@Preview
@Composable
fun PreviewStartScreen() {
    StartScreen()
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewStartScreen() {
//    ModalNavigationDrawer(
//        drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
//        drawerContent = {
//            DrawerContentStart(
//                navController = rememberNavController(),
//                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
//                coroutineScope = rememberCoroutineScope()
//            )
//        }
//    ) {
//        StartScreen(rememberNavController())
//    }
//}
