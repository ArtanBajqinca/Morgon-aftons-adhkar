package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import artan.bajqinca.morgon_afton_dhikr.navigation.Screen
import artan.bajqinca.morgon_afton_dhikr.views.components.CustomTopBar

@Composable
fun AftonScreen(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBar(navController, title = "Aftons adhkar")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAftonScreen() {
    Surface(color = colorResource(id = R.color.light_beige)) {
        AftonScreen()
    }
}
