package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.Screen
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarCard
import artan.bajqinca.morgon_afton_dhikr.views.components.AdhkarTitleDesc
import artan.bajqinca.morgon_afton_dhikr.views.components.CustomTopBar

@Composable
fun AftonScreen(navController: NavController = rememberNavController()) {
    Column(modifier = Modifier.fillMaxSize()) {
        CustomTopBar(navController, title = "Aftons adhkar")

        LazyColumn {
            item {
                AdhkarTitleDesc(
                    arabicText = "اذكار الصباح",
                    descriptionText = "Dens tid är efter Asr-bönen fram till solnedgången"
                )

                AdhkarCard(
                    number = 1,
                    swedishText = "Vi har trätt in i en ny dag och Herraväldet och alla lovprisningar hör till Allah. Ingen har rätt att dyrkas förutom Allah. Han är en och Han har ingen vid Sin sida. Till Honom hör Herraväldet och all pris och Han är kapabel till allting. O Herre! Jag ber om det goda [som finns] i denna dag och det goda efter den, och jag söker skydd från det onda [som finns] i denna dag och det onda efter den. Herre! Jag söker skydd från lathet och svag ålderdom. Herre! Jag söker skydd från straff i elden och straff i graven.",
                    arabicText = "أصْبَحْنَا وَأصْبَحَ الـمُلْكُ لِلَّـهِ، وَالـحَمْدُ لِلَّـهِ، لا إلهَ إلاَّ اللهُ وَحْدَهُ لا شَرِيْكَ لَهُ، لَهُ الـمُلْكُ، ولَهُ الـحَمْدُ، وهُوَ عَلَى كُلِّ شَيءٍ قَدِيرٌ، رَبِّ أسْألُكَ خَيْرَ مَا في هَذَا اليَوْمِ وَخَيْرَ مَا بَعْدَهُ، وأَعُوذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اليَوْمِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أعُوذُ بِكَ مِنَ الكَسَلِ، وسُوءِ الكِبَرِ، رَبِّ أعُوذُ بِكَ مِنْ عَذَابٍ فِي النَّارِ وعَذَابٍ فِي القَبْرِ",
                    transliteration = "Asbahnâ wa asbahal-mulku lillâh walhamdu lillâh, lâ ilâha illallâhu wahdahu lâ sharîka lah, lahul-mulku wa lahul-hamdu wa Huwa 'alâ kulli shay´in qadîr. Rabbi as´aluka khayra mâ fî hâthal-yawm wa khayra mâ ba'da wa a'ûthu bika min sharri mâ fî hâthal-yawmi wa sharri mâ ba'da, Rabbi a'ûthu bika minal-kasal, wa sû´il-kibar, Rabbi a'ûthu bika min 'athâbin fin-nâri wa 'athâbin fil-qabr.",
                    source = "Muslim 4/2088 nr 2723",
                ) {}

                AdhkarCard(
                    number = 2,
                    swedishText = "Allah! Med Din välsignelse träder vi in i dagen, och med Din välsignelse träder vi in i kvällen. Med Din välsignelse lever vi och dör vi, och till Dig återuppstår vi på Domedagen.",
                    arabicText = "اللَّهُمَّ بِكَ أصْبَحْنَا، وبِكَ أمْسَيْنَا، وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وإلَيْكَ النُّشُورُ",
                    transliteration = "Allahumma bika asbahnâ, wa bika amsaynâ, wa bika nahyâ, wa bika namût wa ilaykan-nushûr.",
                    source = "At-Tirmidhî 5/466 nr 3391",
                ) {}

                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .background(colorResource(id = R.color.extra_light_beige))
                )
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAftonScreen() {
    Surface(color = colorResource(id = R.color.light_beige)) {
        AftonScreen()
    }
}