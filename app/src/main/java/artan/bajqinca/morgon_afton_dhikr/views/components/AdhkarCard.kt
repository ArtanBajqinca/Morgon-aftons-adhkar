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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranTypography
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel

@Composable
fun AdhkarCard(
    number: Int,
    swedishText: String,
    arabicText: String,
    transliteration: String,
    source: String,
    reward: String,
    numberBackgroundColor: Color,
    repetitionText: String?,
    repetitionTextArabic: String?,
    svKapitel: String?,
    arKapitel: String?,

    ) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog && reward.isNotEmpty()) {
        ShowRewardDialog(rewardText = reward) {
            showDialog = false
        }
    }
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
            .background(colorResource(id = R.color.light_beige))
            .padding(horizontal = 24.dp),
    ) {
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
        Spacer(modifier = Modifier.height(30.dp))
        // Swedish text
        if (swedishText.isNotEmpty()) {
            Text(
                modifier = if (repetitionText.isNullOrEmpty()) Modifier.padding(bottom = 30.dp)
                else Modifier.padding(bottom = 13.dp),
                text = swedishText,
                style = AvenirTypography.titleMedium,
                color = colorResource(id = R.color.gray)
            )
            // Repetition sv
            if (!repetitionText.isNullOrEmpty()) {
                Text(
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 30.dp),
                    text = repetitionText,
                    style = AvenirTypography.titleSmall,
                    color = colorResource(id = R.color.gray),
                )
            }
        }

        // Transliteration
        if (transliteration.isNotEmpty()) {
            Text(
                modifier = if (repetitionText.isNullOrEmpty()) Modifier.padding(bottom = 30.dp)
                else Modifier.padding(bottom = 13.dp),
                text = transliteration,
                style = AvenirTypography.titleMedium,
                color = colorResource(id = R.color.gray)
            )
            // Repetition transliteration
            if(!repetitionText.isNullOrEmpty()) {
                Text(
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 30.dp),
                    text = repetitionText ?: "",
                    style = AvenirTypography.titleSmall,
                    color = colorResource(id = R.color.gray),
                )
            }
        }

        if (arabicText.isNotEmpty()) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                // Arabic text
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    if(arabicText.isNotEmpty()) {
                        Text(
                            modifier = if (repetitionTextArabic.isNullOrEmpty())
                                Modifier.padding(bottom = 40.dp)
                            else Modifier.padding(bottom = 0.dp),
                            text = arabicText,
                            style = MeQuranTypography.titleMedium,
                            color = colorResource(id = R.color.gray)
                        )
                    }
                }
            }
        }

        // Repetition ar
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            if (!repetitionTextArabic.isNullOrEmpty() && arabicText != "") {
                Text(
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(bottom = 30.dp),
                    text = repetitionTextArabic ?: "",
                    style = MeQuranTypography.titleSmall,
                    color = colorResource(id = R.color.gray),
                )
            }
        }
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

            Spacer(modifier = Modifier.weight(1f))

            // align to End
            if (reward.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFBEB283))
                        .clickable { showDialog = true }
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .padding(top = 4.dp)
                ) {
                    Text(
                        text = "LÄS BELÖNING".uppercase(),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.1.sp,
                            color = colorResource(id = R.color.light_beige)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdhkarCard() {
    AdhkarCard(
        number = 1,
        swedishText = "Vi har kommit till kvällen och kungadömet tillhör Allah",
        arabicText ="أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ",
        transliteration = "Asbahna wa asbahal mulku lillah",
        source = "Bukhari",
        reward = "hej",
        numberBackgroundColor = colorResource(id = R.color.blue),
        svKapitel = "",
        arKapitel = "",
        repetitionText = "",
        repetitionTextArabic = "3 gånger"
    )
}