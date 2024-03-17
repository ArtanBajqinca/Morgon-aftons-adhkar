package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.navigation.ScreenRoutes
import artan.bajqinca.morgon_afton_dhikr.views.components.BackButton
import artan.bajqinca.morgon_afton_dhikr.views.components.TimeRewardCard

@Composable
fun RewardScreen(navController: NavController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue)),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.settings_bg),
            contentDescription = "Settings Background"
        )
        Column()
        {
            Spacer(modifier = Modifier.height(80.dp))
            BackButton {
                navController.popBackStack()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.width(310.dp),
            ) {
                Spacer(modifier = Modifier.height(200.dp))
                Text(
                    text = "Fördelarna \n" +
                            "med adhkar",
                    style = TextStyle(
                        fontFamily = AvenirFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 38.sp,
                        color = Color.White
                    ),
                )
                Spacer(modifier = Modifier.height(40.dp))
                TimeRewardCard(
                    title = "Närhet till Allah",
                    titleColor = R.color.blue,
                    icon = R.drawable.narhet_icon,
                    iconWidth = 57,
                    description = "Genom att praktisera adhkar stärker en person sin tro och förbättrar sin relation med Allah"
                )
                // end of composable named TimeRewardCard
                Spacer(modifier = Modifier.height(40.dp))
                TimeRewardCard(
                    title = "Sinnesro & lugn",
                    titleColor = R.color.blue,
                    icon = R.drawable.sinnesro_icon,
                    iconWidth = 42,
                    description = "Adhkar erbjuder ett sätt att hitta lugn och ro i hjärtat"
                )
                Spacer(modifier = Modifier.height(40.dp))

                TimeRewardCard(
                    title = "Skydd",
                    titleColor = R.color.blue,
                    icon = R.drawable.skydd_icon,
                    iconWidth = 47  ,
                    description = "Regelbunden adhkar är ett skydd mot onda influenser"
                )
            }
        }
    }
}

@Preview
@Composable
fun RewardScreenPreview() {
    RewardScreen()
}