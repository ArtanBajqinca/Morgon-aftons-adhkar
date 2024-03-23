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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.AvenirTypography
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranFont
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranTypography

@Composable
fun AyatAlKursi(
    swedishTitle: String,
    swedishText: String,
    transliteration: String,
    arabicTitle: String,
    arabicText: String,
    numberBackgroundColor: Color,
    source: String = "Den Ädla Koranen, 2:255"
){
    Spacer(modifier = Modifier.height(30.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(colorResource(id = R.color.extra_light_beige))
    )
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
                text = "12",
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.light_beige)
                )
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = swedishTitle,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = numberBackgroundColor
            )
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Swedish translation
        Text(
            text = swedishText,
            style = AvenirTypography.titleMedium,
            color = colorResource(id = R.color.gray)
        )
        Spacer(modifier = Modifier.height(30.dp))
        // Transliteration
        Text(
            text = transliteration,
            style = AvenirTypography.titleMedium,
            color = colorResource(id = R.color.gray)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            // Arabic title
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Text(
                    text = arabicTitle,
                    style = TextStyle(
                        fontFamily = MeQuranFont,
                        fontSize = 31.sp,
                        letterSpacing = 5.sp,
                        color = numberBackgroundColor
                    )
                )
                Spacer(modifier = Modifier.height(30.dp))
                // Quran arabic text
                Text(
                    text = arabicText,
                    style = MeQuranTypography.titleMedium,
                    color = colorResource(id = R.color.gray)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
        Text(
            text = source,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 26.sp,
                color = colorResource(id = R.color.gray)
            )
        )
    }
}

@Preview
@Composable
fun AyatAlKursiPreview() {
    AyatAlKursi(
        swedishTitle = "Ayat al-Kursi",
        swedishText =  "Allah! - det finns ingen sann gud utom Han, den Levande, skapelsens evige Vidmakthållare. Slummer överraskar Honom inte och inte heller sömn. Honom tillhör allt det som himlarna rymmer och det som jorden bär. Vem är den som vågar tala [för någon] inför Honom utan Hans tillstånd? Han vet allt vad [människor] kan veta och allt som är dolt för dem och av Hans kunskap kan de inte omfatta mer än Han tillåter. Hans fotpall omsluter himlarna och jorden. Att värna och bevara dem är för Honom ingen börda. Han är den Höge, den Väldige.",
        transliteration = "Allahu lâ ilâha illâ Huwal-Hayyul-Qayyûm, lâ ta´khuthuhu sinatun wa lâ nawm, lahu mâ fis-samâwâti wa mâfil-ardh, man thal-lathî yashfa'u 'indahu illâ bi'ithnih, ya'lamu mâ bayna aydîhim wa mâ khalfahum, wa lâ yuhîtûna bishay´im-min 'ilmihi illâ bimâ shâ´a, wasi'a kursiyyuhus-samâwâti wal ardha, wa lâ ya'ûduhu hifdhuhumâ, wa Huwal-'Aliyyul-'Adhîm.",
        arabicTitle = "آية الكرسي" ,
        arabicText = "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ\n\n ۞ اللَّهُُ لا إِلٰهَ إِلّا هُوَ الحَيُّ القَيّومُ لا تَأخُذُهُ سِنَةٌ وَلا نَومٌ لَهُ ما فِي السَّماواتِ وَما فِي الأَرضِ مَن ذَا الَّذي يَشفَعُ عِندَهُ إِلّا بِإِذنِهِ يَعلَمُ ما بَينَ أَيديهِم وَما خَلفَهُم وَلا يُحيطونَ بِشَيءٍ مِن عِلمِهِ إِلّا بِما شاءَ وَسِعَ كُرسِيُّهُ السَّماواتِ وَالأَرضَ وَلا يَئودُهُ حِفظُهُما وَهُوَ العَلِيُّ العَظيمُ ۞",
        numberBackgroundColor = colorResource(id = R.color.blue),
        source = "Den Ädla Koranen, 2:255"
    )
}