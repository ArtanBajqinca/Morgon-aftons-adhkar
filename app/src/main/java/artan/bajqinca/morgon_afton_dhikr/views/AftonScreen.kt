package artan.bajqinca.morgon_afton_dhikr.views

import DataParser
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun AftonScreen(navController: NavController = rememberNavController()) {

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
                                descriptionText = "Dens tid är efter Asr-bönen fram till solnedgången"
                            )
                        }

                        items(list) { adhkar ->
                            // Ayat al kursi
                            if (list.indexOf(adhkar) == 11) {
                                AyatAlKursi(
                                    swedishTitle = "Ayat al-Kursi",
                                    swedishText =  "Allah! - det finns ingen sann gud utom Han, den Levande, skapelsens evige Vidmakthållare. Slummer överraskar Honom inte och inte heller sömn. Honom tillhör allt det som himlarna rymmer och det som jorden bär. Vem är den som vågar tala [för någon] inför Honom utan Hans tillstånd? Han vet allt vad [människor] kan veta och allt som är dolt för dem och av Hans kunskap kan de inte omfatta mer än Han tillåter. Hans fotpall omsluter himlarna och jorden. Att värna och bevara dem är för Honom ingen börda. Han är den Höge, den Väldige.",
                                    transliteration = "Allahu lâ ilâha illâ Huwal-Hayyul-Qayyûm, lâ ta´khuthuhu sinatun wa lâ nawm, lahu mâ fis-samâwâti wa mâfil-ardh, man thal-lathî yashfa'u 'indahu illâ bi'ithnih, ya'lamu mâ bayna aydîhim wa mâ khalfahum, wa lâ yuhîtûna bishay´im-min 'ilmihi illâ bimâ shâ´a, wasi'a kursiyyuhus-samâwâti wal ardha, wa lâ ya'ûduhu hifdhuhumâ, wa Huwal-'Aliyyul-'Adhîm.",
                                    arabicTitle = "آية الكرسي" ,
                                    arabicText = "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ\n\n ۞ اللَّهُُ لَا إِلٰهَ إِلّا هُوَ الْحَيُّ الْقَيّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَومٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلّا بِإِذْنِهِ يَعْلَمُ مَا بَينَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيءٍ مِن عِلْمِهِ إِلّا بِمَا شاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ ۞",
                                    numberBackgroundColor = colorResource(id = R.color.blue),
                                    source = "Den Ädla Koranen, 2:255"
                                )
                            }
                            // skips an adhkar to let ayat al kursi be displayed
                            if (adhkar.id != 12) {
                                AdhkarCard(
                                    number = list.indexOf(adhkar) + 1,
                                    swedishText = adhkar.sv,
                                    arabicText = adhkar.ar,
                                    transliteration = adhkar.transliteration,
                                    source = adhkar.source,
                                    reward = adhkar.reward,
                                    numberBackgroundColor = colorResource(id = R.color.blue),
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

@Preview(showBackground = true)
@Composable
fun PreviewAftonScreen() {
    AyatAlKursi(
        swedishTitle = "Ayat al-Kursi",
        swedishText =  "Allah! - det finns ingen sann gud utom Han, den Levande, skapelsens evige Vidmakthållare. Slummer överraskar Honom inte och inte heller sömn. Honom tillhör allt det som himlarna rymmer och det som jorden bär. Vem är den som vågar tala [för någon] inför Honom utan Hans tillstånd? Han vet allt vad [människor] kan veta och allt som är dolt för dem och av Hans kunskap kan de inte omfatta mer än Han tillåter. Hans fotpall omsluter himlarna och jorden. Att värna och bevara dem är för Honom ingen börda. Han är den Höge, den Väldige.",
        transliteration = "Allahu lâ ilâha illâ Huwal-Hayyul-Qayyûm, lâ ta´khuthuhu sinatun wa lâ nawm, lahu mâ fis-samâwâti wa mâfil-ardh, man thal-lathî yashfa'u 'indahu illâ bi'ithnih, ya'lamu mâ bayna aydîhim wa mâ khalfahum, wa lâ yuhîtûna bishay´im-min 'ilmihi illâ bimâ shâ´a, wasi'a kursiyyuhus-samâwâti wal ardha, wa lâ ya'ûduhu hifdhuhumâ, wa Huwal-'Aliyyul-'Adhîm.",
        arabicTitle = "آية الكرسي" ,
        arabicText = "۞ ٱللَّهُ لَآ إِلَٰهَ إِلَّا هُوَ ٱلۡحَيُّ ٱلۡقَيُّومُۚ لَا تَأۡخُذُهُۥ سِنَةٞ وَلَا نَوۡمٞۚ لَّهُۥ مَا فِي ٱلسَّمَٰوَٰتِ وَمَا فِي ٱلۡأَرۡضِۗ مَن ذَا ٱلَّذِي يَشۡفَعُ عِندَهُۥٓ إِلَّا بِإِذۡنِهِۦۚ يَعۡلَمُ مَا بَيۡنَ أَيۡدِيهِمۡ وَمَا خَلۡفَهُمۡۖ وَلَا يُحِيطُونَ بِشَيۡءٖ مِّنۡ عِلۡمِهِۦٓ إِلَّا بِمَا شَآءَۚ وَسِعَ كُرۡسِيُّهُ ٱلسَّمَٰوَٰتِ وَٱلۡأَرۡضَۖ وَلَا يَ‍ُٔودُهُۥ حِفۡظُهُمَاۚ وَهُوَ ٱلۡعَلِيُّ ٱلۡعَظِيمُ ۞",
        numberBackgroundColor = colorResource(id = R.color.blue)
    )

}
