package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes

@Composable
fun TopNavigationBar(
    navController: NavController,
    title: String,
    onBackClick: () -> Unit = { navController.navigate(ScreenRoutes.StartScreen.route) },
    onMenuClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.gray)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Left side - Back Icon Box
        Box(
            modifier = Modifier
                .width(55.dp)
                .height(75.dp)
                .clickable { onBackClick() }
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_icon),
                contentDescription = "Back icon",
                modifier = Modifier.size(30.dp)
            )
        }
        // Center - Title Text
        Text(
            text = title,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                color = colorResource(id = R.color.light_beige)
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp) // add padding to ensure title doesn't get squished
                .padding(top = 2.dp)
        )
        // Right side - Menu Icon Box or Spacer if no menu icon is needed
        if (onMenuClick != {}) {
            Box(
                modifier = Modifier
                    .width(55.dp)
                    .height(75.dp)
                    .clickable { onMenuClick() }
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.setting_icon),
                    contentDescription = "Menu icon",
                    modifier = Modifier.size(32.dp)
                )
            }
        } else {
            // If there is no menu icon, still occupy the space to keep the title centered
            Spacer(modifier = Modifier.weight(1f).padding(end = 16.dp))
        }
    }
}


@Preview
@Composable
fun CustomTopBarPreview() {
    TopNavigationBar(navController = NavController(
        context = androidx.compose.ui.platform.LocalContext.current
    ), title = "Morgon")
}