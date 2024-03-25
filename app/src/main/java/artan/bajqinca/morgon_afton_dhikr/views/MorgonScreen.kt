package artan.bajqinca.morgon_afton_dhikr.views

import DataParser
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import artan.bajqinca.morgon_afton_dhikr.views.components.AyatAlKursi
import artan.bajqinca.morgon_afton_dhikr.views.components.TopNavigationBar
import artan.bajqinca.morgon_afton_dhikr.views.components.DrawerContentAdhkarScreen
import artan.bajqinca.morgon_afton_dhikr.views.components.EndOfScreen
import kotlinx.coroutines.launch

@Composable
fun MorgonScreen(navController: NavController = rememberNavController()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val dataParser = DataParser(LocalContext.current)
    val list = dataParser.getMorningAdhkarList()

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
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.light_beige))
                ) {
                    TopNavigationBar(
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
                                title = "Morgons adhkar",
                                descriptionText = "Dens tid är efter fajr-bönen fram till soluppgången"
                            )
                        }
                        itemsIndexed(list) { index, adhkar ->
                            if (adhkar.arKapitel != null) {
                                AyatAlKursi(
                                    number = index + 1,
                                    swedishTitle = adhkar.svKapitel,
                                    swedishText = adhkar.sv,
                                    transliteration = adhkar.transliteration,
                                    arabicTitle = adhkar.arKapitel ,
                                    arabicText = adhkar.ar,
                                    numberBackgroundColor = colorResource(id = R.color.dark_orange),
                                    source = adhkar.source
                                ) } else if (adhkar.arKapitel == null) {
                                AdhkarCard(
                                    number = index + 1, // Use index + 1 as the ID so it starts from 1
                                    swedishText = adhkar.sv,
                                    arabicText = adhkar.ar,
                                    transliteration = adhkar.transliteration,
                                    source = adhkar.source,
                                    reward = adhkar.reward,
                                    numberBackgroundColor = colorResource(id = R.color.dark_orange),
                                    svKapitel = adhkar.svKapitel,
                                    arKapitel = adhkar.arKapitel,
                                    repetitionText = adhkar.repetitionText,
                                    repetitionTextArabic = adhkar.repetitionTextArabic
                                )
                            }
                        }
                        item {
                            EndOfScreen()
                        }
                    }
                }
            }
        }
    }
}