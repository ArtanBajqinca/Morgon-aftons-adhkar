package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import artan.bajqinca.morgon_afton_dhikr.R

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
            .background(color = colorResource(id = R.color.gray))
            .width(100.dp)
            .height(57.dp)
            .clickable(onClick = onClick),
    ){
        Image(
            modifier = Modifier
                .padding(end = 30.dp)
                .width(28.dp)
                .align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.arrow_icon),
            contentDescription = "Arrow Icon",
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}