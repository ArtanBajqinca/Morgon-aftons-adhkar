package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
    number: Int,
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
    Spacer(modifier = Modifier.height(30.dp))

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
                text = number.toString(),
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
        // Swedish title
        if(swedishTitle.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(vertical = 30.dp),
                text = swedishTitle,
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = numberBackgroundColor
                )
            )
        }

        // Swedish translation
        if(swedishText.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                text = swedishText,
                style = AvenirTypography.titleMedium,
                color = colorResource(id = R.color.gray)
            )
        }
        // Transliteration
        if(transliteration.isNotEmpty()) {
            Text(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                text = transliteration,
                style = AvenirTypography.titleMedium,
                color = colorResource(id = R.color.gray)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            // Arabic title
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                if(arabicTitle.isNotEmpty()) {
                    Text(
                        modifier = Modifier
                            .padding(bottom = 30.dp),
                        text = arabicTitle,
                        style = TextStyle(
                            fontFamily = MeQuranFont,
                            fontSize = 31.sp,
                            letterSpacing = 5.sp,
                            color = numberBackgroundColor
                        )
                    )
                }

                if(arabicText.isNotEmpty()) {
                    // Quran arabic text
                    Text(
                        modifier = Modifier
                            .padding(bottom = 40.dp),
                        text = arabicText,
                        style = MeQuranTypography.titleMedium,
                        color = colorResource(id = R.color.gray)
                    )
                }
            }
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.light_beige))
    ) {
        AyatAlKursi(
            swedishTitle = "Ayat al-Kursi",
            swedishText = " Allah! - det finns ingen sann gud utom Han, den Levande, skapelsens evige",
            transliteration = "Allah! - det finns ingen sann gud utom Han, den Levande, skapelsens evige",
            arabicTitle = " آية الكرسي",
            arabicText = " عِلْمِهِ إِلَّا بِمَا شَاءَ ۚ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ ۖ وَلَا يَئُودُهُ حِفْظُهُمَا ۚ وَهُوَ الْعَلِيُّ الْعَظِيمُ",
            numberBackgroundColor = colorResource(id = R.color.blue),
            source = "Den Ädla Koranen, 2:255",
            number = 1
        )
    }
}