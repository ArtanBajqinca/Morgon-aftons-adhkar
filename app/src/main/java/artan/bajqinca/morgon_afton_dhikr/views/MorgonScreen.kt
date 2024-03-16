package artan.bajqinca.morgon_afton_dhikr.views

import DataParser
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarCard
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarTitleDesc
import artan.bajqinca.morgon_afton_dhikr.views.components.CustomTopBar
import artan.bajqinca.morgon_afton_dhikr.views.components.DrawerContentAdhkarScreen
import artan.bajqinca.morgon_afton_dhikr.views.components.EndOfScreen
import kotlinx.coroutines.launch

@Composable
fun MorgonScreen(navController: NavController = rememberNavController()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val dataParser = DataParser(LocalContext.current)
    val list = dataParser.getEveningAdhkarList()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    DrawerContentAdhkarScreen(navController, drawerState, coroutineScope)
                }
            }
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Column(modifier = Modifier.fillMaxSize()) {
                    CustomTopBar(
                        navController = navController,
                        title = "Morgons adhkar",
                        onBackClick = { navController.popBackStack() },
                        onMenuClick = {
                            coroutineScope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }
                    )
                    LazyColumn {
                        item {
                            AdhkarTitleDesc(
                                arabicText = "اذكار الصباح",
                                descriptionText = "Dens tid är efter fajr-bönen fram till soluppgången"
                            )
                            list.forEach {
                                AdhkarCard(
                                    number = it.id,
                                    swedishText = it.sv,
                                    arabicText = it.ar,
                                    transliteration = it.transliteration,
                                    source = it.source,
                                    reward = it.reward,
                                    numberBackgroundColor = colorResource(id = R.color.dark_orange),
                                ) {}
                            }
                            EndOfScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMorgonScreen() {
    DrawerContentAdhkarScreen(navController = rememberNavController(), drawerState = rememberDrawerState(
        initialValue = DrawerValue.Open
    ), coroutineScope = rememberCoroutineScope())
}