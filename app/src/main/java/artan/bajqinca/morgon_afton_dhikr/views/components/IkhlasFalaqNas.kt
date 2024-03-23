package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.AvenirTypography
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranFont
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranTypography

@Composable
fun IkhlasFalaqNas(
    numberBackgroundColor: Color,
    number: Int,
){
    Spacer(modifier = Modifier.height(30.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(colorResource(id = R.color.extra_light_beige))
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(38.dp)
                    .height(38.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(numberBackgroundColor)
                    .padding(top = 4.dp)
                    .padding(end = 2.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "5",
                    style = TextStyle(
                        fontFamily = AvenirFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp,
                        color = colorResource(id = R.color.light_beige)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        SurahSection(
            chapterTitle = "Kapitel Al-Ikhlas",
            swedishTranslation = "I Allahs Namn, Den Nåderike, Den Barmhärtige. Säg Han är Allah, [Han är] En. Allah - Den av skapelsen oberoende, av vilken alla beror. Han har inte avlat och inte heller är Han född, och ingen finns som kan liknas vid Honom.",
            transliteration = "Bismillâhir-Rahmânir-Rahîm.\n" +
                    "Qul HuwAllahu Ahad. Allahus-Samad. Lam yalid wa lam yûlad. Wa lam yakun lahu kufuwan Ahad.",
            chapterTitleArabic = "سورة الإخلاص",
            quranArabicText = "بَسْمِ اللهِ الرَّحْمَنِ الرَّحِيمِ\n" +
                    "قُلْ هُوَ اللهُ أَحَدٌ ۞ اللهُ الصَّمَدُ ۞\n" +
                    "لَمْ يَلِدْ وَلَمْ يُولَد ۞\n" +
                    " وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ ۞"
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(colorResource(id = R.color.extra_light_beige))
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(40.dp))
        SurahSection(
            chapterTitle = "Kapitel Al-Falaq",
            swedishTranslation = "I Allahs Namn, Den Nåderike Den Barmhärtige. Säg: Jag tar skydd hos gryningens Herre. Mot ondskan i det som Han har skapat. Och mot ondskan i natten när den mörknar. Och mot ondskan hos de [magiker] som blåser på knutarna. Och mot den avundsammes ondska när han avundas.",
            transliteration = "Bismillâhir-Rahmânir-Rahîm.\n" +
                    "Qul a'ûthu birabbil-falaq. Min sharri mâ khalaq. Wa min sharri ghâsiqin ithâ waqab. Wa min sharrin-naffâthâti fil-'uqad. Wa min sharri hâsidin ithâ hasad.",
            chapterTitleArabic = "سورة الفلق",
            quranArabicText = "بَسْمِ اللهِ الرَّحْمَنِ الرَّحِيمِ\n" +
                    "  قُلۡ أَعُوذُ بِرَبِّ ٱلۡفَلَقِ۞\n" +
                    " مِن شَرِّ مَا خَلَقَ۞ \n" +
                    "وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ۞\n" +
                    " وَمِن شَرِّ ٱلنَّفَّٰثَٰتِ فِي ٱلۡعُقَدِ۞\n" +
                    " وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ۞"
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(colorResource(id = R.color.extra_light_beige))
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(40.dp))
        SurahSection(
            chapterTitle = "Kapitel An-Nas",
            swedishTranslation = "I Allahs Namn, Den Nåderike Den Barmhärtige.Säg: Jag tar skydd hos människornas Herre. Människornas Konung. Människornas Gud. Mot den förrädiske frestarens ondska. Han som viskar inom människornas bröst. Bland både djinnerna och människorna.",
            transliteration = "Bismillâhir-Rahmânir-Rahîm.\n" +
                    "Qul a'ûthu birabbin-nâs. Malikin-nâs. Ilâhin-nâs. Min sharril-waswâsil-khannâs. Allathî yuwaswisu fî sudûrin-nâs. Minal-djinnati wannâs.",
            chapterTitleArabic = "سورة الناس",
            quranArabicText = "بَسْمِ اللهِ الرَّحْمَنِ الرَّحِيمِ\n" +
                    "  قُلۡ أَعُوذُ بِرَبِّ ٱلنَّاسِ۞\n" +
                    " مَلِكِ ٱلنَّاسِ۞ إِلَٰهِ ٱلنَّاسِ۞\n" +
                    " مِن شَرِّ ٱلۡوَسۡوَاسِ ٱلۡخَنَّاسِ۞ \n" +
                    "ٱلَّذِي يُوَسۡوِسُ فِي صُدُورِ ٱلنَّاسِ۞\n" +
                    " مِنَ ٱلۡجِنَّةِ وَٱلنَّاسِ ۞",
        )
    }
}

@Composable
fun SurahSection(
    numberBackgroundColor: Color = colorResource(id = R.color.blue),
    chapterTitle: String,
    swedishTranslation: String,
    transliteration: String,
    quranArabicText: String,
    repetitionText: String = "(Läses tre gånger)",
    chapterTitleArabic: String = "سورة الإخلاص",
    repetitionTextArabic: String = "(ثَلَاثَ مَرَّات)"
) {
    Text(
        text = chapterTitle,
        style = TextStyle(
            fontFamily = AvenirFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = numberBackgroundColor
        )
    )
    Spacer(modifier = Modifier.height(30.dp))

    // Swedish translation
    Text(
        text = swedishTranslation,
        style = AvenirTypography.titleMedium,
        color = colorResource(id = R.color.gray)
    )
    Spacer(modifier = Modifier.height(13.dp))

    // Repetition
    Text(
        text = repetitionText,
        style = AvenirTypography.titleSmall,
        color = colorResource(id = R.color.gray),
        modifier = Modifier.alpha(0.5f)
    )
    Spacer(modifier = Modifier.height(30.dp))

    // Transliteration
    Text(
        text = transliteration,
        style = AvenirTypography.titleMedium,
        color = colorResource(id = R.color.gray)
    )
    Spacer(modifier = Modifier.height(13.dp))

    // Repetition
    Text(
        text = repetitionText,
        style = AvenirTypography.titleSmall,
        color = colorResource(id = R.color.gray),
        modifier = Modifier.alpha(0.5f)
    )
    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        // Arabic title
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Text(
                text = chapterTitleArabic,
                style = TextStyle(
                    fontFamily = MeQuranFont,
                    fontSize = 27.sp,
                    letterSpacing = 5.sp,
                    color = numberBackgroundColor
                )
            )
            // Quran arabic text
            Text(
                text = quranArabicText,
                style = MeQuranTypography.titleMedium,
                color = colorResource(id = R.color.gray)
            )
            Spacer(modifier = Modifier.height(5.dp))

            // Repetition
            Text(
                text = repetitionTextArabic,
                style = MeQuranTypography.titleSmall,
                color = colorResource(id = R.color.gray),
                modifier = Modifier.alpha(0.5f)
            )
        }
    }
}
