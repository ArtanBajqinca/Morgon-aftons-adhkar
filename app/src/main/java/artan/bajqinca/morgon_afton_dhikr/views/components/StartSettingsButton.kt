package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily

@Composable
fun StartSettingsButton(
    onClick: () -> Unit,
    buttonText: String,
    buttonBackgroundColor: Int,
    settingsIcon: Int
) {
    Box(
        modifier = Modifier
            .height(70.dp)
            .width(210.dp)
            .clip(RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp))
            .background(colorResource(id = buttonBackgroundColor))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart),
        ) {
            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(id = settingsIcon),
                contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                modifier = Modifier
                    .width(120.dp),
                text = buttonText,
                color = Color.White,
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            )
        }
    }
}