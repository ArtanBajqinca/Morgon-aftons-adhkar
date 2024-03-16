package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import artan.bajqinca.morgon_afton_dhikr.R

@Composable
fun StartSettingsTab(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .offset(y = (-90).dp)
            .offset(x = (-170).dp)
            .height(48.dp)
            .width(100.dp)
            .shadow(10.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.gray))
            .clickable(onClick = onClick)
            .padding(end = 14.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.hamburger_icon),
            contentDescription = "Hamburger Icon",
            modifier = Modifier
                .size(24.dp)
        )
    }
}