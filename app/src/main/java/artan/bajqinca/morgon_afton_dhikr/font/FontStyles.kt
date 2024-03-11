package artan.bajqinca.morgon_afton_dhikr.font

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R

val AvenirRoundedFontFamily = FontFamily(
    Font(R.font.avenir_rounded_normal, FontWeight.Normal),
    Font(R.font.avenir_rounded_bold, FontWeight.Bold)
)

val AvenirTypography = Typography(
    titleSmall = TextStyle(
        fontFamily = AvenirRoundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color(0xFFD9D9D9)
    ),
    titleMedium = TextStyle(
        fontFamily = AvenirRoundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color(0xFFD9D9D9)
    ),
    titleLarge = TextStyle(
        fontFamily = AvenirRoundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Color(0xFFD9D9D9)
    ),
    displayMedium = TextStyle(
        fontFamily = AvenirRoundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color(0xFFD9D9D9)
    ),
    displayLarge = TextStyle(
        fontFamily = AvenirRoundedFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = Color(0xFFD9D9D9)
    ),
)
