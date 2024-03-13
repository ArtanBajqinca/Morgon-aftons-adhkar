package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.Screen

@Composable
fun CustomTopBar(
    navController: NavController,
    title: String,
    onBackClick: () -> Unit = { navController.navigate(Screen.StartScreen.route) },
    onMenuClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(colorResource(id = R.color.gray)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clickable(onClick = onBackClick)
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_icon),
                contentDescription = "Back icon",
                modifier = Modifier.size(28.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                color = colorResource(id = R.color.light_beige)
            ),
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.clickable(onClick = onMenuClick)) {
            Image(
                painter = painterResource(id = R.drawable.hamburger_icon),
                contentDescription = "Menu icon",
                modifier = Modifier.width(25.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}