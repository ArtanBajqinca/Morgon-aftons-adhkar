package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.LoraFont

@Composable
fun TimeRewardCard(
    title: String,
    titleColor: Int,
    icon: Int,
    iconWidth: Int,
    description: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(vertical = 5.dp, horizontal = 20.dp),
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = LoraFont,
                    fontSize = 24.sp,
                    color = colorResource(id = titleColor),
                ),
            )
        }
        Spacer(modifier = Modifier.width(20.dp))

        Image(
            painter = painterResource(id = icon),
            contentDescription = "Narhet Icon",
            modifier = Modifier
                .width(iconWidth.dp)
        )
    }
    Spacer(modifier = Modifier.height(15.dp))

    Text(
        text = description,
        style = TextStyle(
            fontFamily = AvenirFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 18.sp,
            lineHeight = 20.sp,
            color = Color.White,
        ),
    )
}