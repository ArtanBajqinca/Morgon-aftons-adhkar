package artan.bajqinca.morgon_afton_dhikr.font

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R

val AvenirFontFamily = FontFamily(
    Font(R.font.avenir_bold, FontWeight.Bold),
    Font(R.font.avenir_demi, FontWeight.W600),
    Font(R.font.avenir_regular, FontWeight.Normal),
    Font(R.font.avenir_light, FontWeight.Light),
    Font(R.font.avenir_ultra_light, FontWeight.ExtraLight),
)

val LoraFont = FontFamily(
    Font(R.font.lora_bold)
)

val MeQuranFont = FontFamily(
    Font(R.font.me_quran)
)

val NotoSansArabicFont = FontFamily(
    Font(R.font.noto_sans_arabic_extra_bold),
)

val AvenirTypography = Typography(
    titleSmall = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 12.sp,
        color = Color.Black
    ),
    titleMedium = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 24.sp,
        color = Color(0xFFD9D9D9)
    ),
    titleLarge = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 30.sp,
        color = Color.Black
    ),
    displaySmall = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 20.sp,
        color = Color.Black
    ),
    displayMedium = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 20.sp,
        color = Color.Black
    ),
    displayLarge = TextStyle(
        fontFamily = AvenirFontFamily,
        fontSize = 40.sp,
        color = Color.Black
    ),
)
