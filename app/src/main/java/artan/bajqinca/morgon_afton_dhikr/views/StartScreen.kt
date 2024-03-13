package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.navigation.Screen
import artan.bajqinca.morgon_afton_dhikr.views.components.ImageBtn

@Composable
fun StartScreen(navController: NavController = rememberNavController()) {
    Column() {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFFBE741A)),
            contentAlignment = Alignment.Center
        ) {
            ImageBtn(
                image = R.drawable.morgon_image_btn,
                onClick = { navController.navigate(Screen.MorgonScreen.route) }
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(y = 80.dp)
                    .offset(x = (-20).dp)
                    .height(48.dp)
                    .width(100.dp)
                    .shadow(10.dp, shape = RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp))
                    .background(colorResource(id = R.color.gray))
                    .padding(end = 14.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hamburger_icon),
                    contentDescription = "Hamburger Icon",
                    modifier = Modifier
                        .width(25.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(id = R.color.blue)),
            contentAlignment = Alignment.Center
        ) {

            ImageBtn(
                image = R.drawable.afton_image_btn,
                onClick = { navController.navigate(Screen.AftonScreen.route) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    StartScreen()
}
