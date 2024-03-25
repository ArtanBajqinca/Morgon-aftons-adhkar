package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.NotoSansArabicFont

@Composable
fun AdhkarTitleDesc(title: String, arabicText: String, descriptionText: String) {
    Spacer(modifier = Modifier.height(40.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(colorResource(id = R.color.extra_light_beige))
    )
    Spacer(modifier = Modifier.height(40.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = arabicText,
            style = TextStyle(
                fontFamily = NotoSansArabicFont,
                fontSize = 36.sp,
                color = colorResource(id = R.color.gray)
            )
        )
    }
    Spacer(modifier = Modifier.height(30.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = colorResource(id = R.color.gray)
            )
        )
    }
    Spacer(modifier = Modifier.height(30.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .width(330.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = descriptionText.uppercase(),
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp,
                    color = colorResource(id = R.color.gray),
                    lineHeight = 22.sp,
                    letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun AdhkarTitleDescPreview() {
    AdhkarTitleDesc(
        arabicText = "اذكار الصباح",
        title = "Morgons adhkar",
        descriptionText = "Dens tid är efter Asr-bönen fram till solnedgången"
    )
}

