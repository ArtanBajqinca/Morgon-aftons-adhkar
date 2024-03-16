package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
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
            .offset { IntOffset(-70, 0) }
            .height(70.dp)
            .width(230.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(id = buttonBackgroundColor))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterStart),
        ) {
            Spacer(modifier = Modifier.width(25.dp))
            Image(
                painter = painterResource(id = settingsIcon),
                contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
            Spacer(modifier = Modifier.width(17.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
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