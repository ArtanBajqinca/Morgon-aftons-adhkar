package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
@Composable
fun SettingsTextAndCheckmark(
    text: String,
    initiallyTicked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    var isTicked by remember { mutableStateOf(initiallyTicked) }

    Row(
        modifier = Modifier
            .width(164.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(5.dp))
                .clickable {
                    isTicked = !isTicked
                    onCheckedChange(isTicked)
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = if (isTicked) R.drawable.checkmark_ticked else R.drawable.checkmark_unticked),
                contentDescription = if (isTicked) "Checkmark ticked" else "Checkmark unticked",
                modifier = Modifier
                    .width(25.dp)
            )
        }

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            color = colorResource(id = R.color.light_beige),
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 19.sp
            )
        )
    }
}
