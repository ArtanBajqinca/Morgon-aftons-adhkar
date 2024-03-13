package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranFont

@Composable
fun AdhkarCard(
    number: Int,
    swedishText: String,
    arabicText: String,
    transliteration: String,
    source: String,
    onSeeRewardClick: () -> Unit
) {

    Spacer(modifier = Modifier.height(40.dp))

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

        // Number indicator
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
                    .background(colorResource(id = R.color.light_orange)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    modifier = Modifier.padding(top = 4.dp),
                    style = TextStyle(
                        fontFamily = AvenirFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp,
                        color = colorResource(id = R.color.light_beige)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        // Swedish text
        Text(
            text = "$swedishText",
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontSize = 19.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 26.sp,
                color = colorResource(id = R.color.gray)
            )
        )
        Spacer(modifier = Modifier.height(15.dp))

        // Arabic text
        Text(
            text = arabicText,
            style = TextStyle(
                fontFamily = MeQuranFont,
                fontSize = 27.sp,
                lineHeight = 45.sp,
                color = colorResource(id = R.color.gray)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Transliteration
        Text(
            text = transliteration,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontSize = 19.sp,
                fontWeight = FontWeight.W600,
                lineHeight = 26.sp,
                color = colorResource(id = R.color.gray)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Source and "se belöning" button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFBEB283))
                    .clickable { onSeeRewardClick() }
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .padding(top = 4.dp),
            ) {
                Text(
                    text = "LÄS BELÖNING".uppercase(),
                    style = TextStyle(
                        fontFamily = AvenirFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.light_beige)
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAdhkarCard() {
    AdhkarCard(
        number = 1,
        swedishText = "In the name of Allah, the Entirely Merciful, the Especially Merciful.",
        arabicText = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
        transliteration = "Bismillahir-Rahmanir-Rahim",
        source = "Sahih International",
        onSeeRewardClick = {}
    )
}
