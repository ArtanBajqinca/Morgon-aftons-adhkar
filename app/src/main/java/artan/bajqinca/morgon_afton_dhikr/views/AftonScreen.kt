package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarCard
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarTitleDesc
import artan.bajqinca.morgon_afton_dhikr.views.components.AyatAlKursi
import artan.bajqinca.morgon_afton_dhikr.views.components.TopNavigationBar
import artan.bajqinca.morgon_afton_dhikr.views.components.DrawerContentAdhkarScreen
import artan.bajqinca.morgon_afton_dhikr.views.components.EndOfScreen
import kotlinx.coroutines.launch

@Composable
fun AftonScreen(
    navController: NavController = rememberNavController(),
    viewModel: TextOptionsViewModel,
    adhkarViewModel: AdhkarViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val list = adhkarViewModel.eveningAdhkarList

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    DrawerContentAdhkarScreen(navController, drawerState, viewModel, coroutineScope)
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
                        title = "Aftons adhkar",
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
                                arabicText = "اذكار المساء",
                                title = "Aftons adhkar",
                                descriptionText = "Dens tid är efter Asr-bönen fram till Isha-bönen"
                            )
                        }
                        itemsIndexed(list) { index, adhkar ->
                            if (!adhkar.arKapitel.isNullOrEmpty()) {
                                AyatAlKursi(
                                    number = index + 1,
                                    swedishTitle = adhkar.svKapitel,
                                    swedishText = if (viewModel.showTranslation) adhkar.sv else "",
                                    transliteration = if (viewModel.showTransliteration)  adhkar.transliteration else "",
                                    arabicTitle = if (viewModel.showArabic) adhkar.arKapitel else "",
                                    arabicText = if (viewModel.showArabic) adhkar.ar else "",
                                    numberBackgroundColor = colorResource(id = R.color.blue),
                                    source = adhkar.source,
                                    reward = adhkar.reward
                                ) } else
                                AdhkarCard(
                                    number = index + 1,
                                    swedishText = if (viewModel.showTranslation) adhkar.sv else "",
                                    arabicText = if (viewModel.showArabic) adhkar.ar else "",
                                    transliteration = if (viewModel.showTransliteration)  adhkar.transliteration else "",
                                    source = adhkar.source,
                                    reward = adhkar.reward,
                                    numberBackgroundColor = colorResource(id = R.color.blue),
                                    svKapitel = adhkar.svKapitel,
                                    arKapitel = adhkar.arKapitel,
                                    repetitionText = adhkar.repetitionText,
                                    repetitionTextArabic = adhkar.repetitionTextArabic
                                )
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

