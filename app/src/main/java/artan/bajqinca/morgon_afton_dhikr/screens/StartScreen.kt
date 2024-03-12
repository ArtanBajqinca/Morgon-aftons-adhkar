package artan.bajqinca.morgon_afton_dhikr.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily

@Composable
fun StartScreen(navController: NavController = rememberNavController()) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Start Screen",
            style = TextStyle(
                fontFamily = AvenirFontFamily,
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 32.dp)
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate(Screen.MorgonScreen.route) },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.dark_orange)
            )
        ) {
            Text(
                text = "Go to Morgon screen",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.AftonScreen.route) },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.blue)
            )
        ) {
            Text(
                text = "Go to Afton screen",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    Surface(color = colorResource(id = R.color.light_beige)) {
        StartScreen()
    }
}
