package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.viewModel.AdhkarViewModel
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel
import artan.bajqinca.morgon_afton_dhikr.views.components.*
import kotlinx.coroutines.launch

@Composable
fun MorgonScreen(
    navController: NavController = rememberNavController(),
    textOptionsViewModel: TextOptionsViewModel,
    adhkarViewModel: AdhkarViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val list = adhkarViewModel.morningAdhkarList

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    DrawerContentAdhkarScreen(navController, drawerState, textOptionsViewModel, coroutineScope)
                }
            }
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Column(
                    modifier = Modifier
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
                            if (!adhkar.arKapitel.isNullOrEmpty()) {
                                AyatAlKursi(
                                    number = index + 1,
                                    swedishTitle = adhkar.svKapitel,
                                    swedishText = if (textOptionsViewModel.showTranslation) adhkar.sv else "",
                                    transliteration = if (textOptionsViewModel.showTransliteration) adhkar.transliteration else "",
                                    arabicTitle = if (textOptionsViewModel.showArabic) adhkar.arKapitel else "",
                                    arabicText = if (textOptionsViewModel.showArabic) adhkar.ar else "",
                                    numberBackgroundColor = colorResource(id = R.color.dark_orange),
                                    source = adhkar.source,
                                    reward = adhkar.reward
                                )
                            } else {
                                AdhkarCard(
                                    number = index + 1, // Use index + 1 as the ID so it starts from 1
                                    swedishText = if (textOptionsViewModel.showTranslation) adhkar.sv else "",
                                    arabicText = if (textOptionsViewModel.showArabic) adhkar.ar else "",
                                    transliteration = if (textOptionsViewModel.showTransliteration) adhkar.transliteration else "",
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
