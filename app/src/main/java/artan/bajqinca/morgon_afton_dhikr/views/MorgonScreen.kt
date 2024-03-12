package artan.bajqinca.morgon_afton_dhikr.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.views.components.CustomTopBar

@Composable
fun MorgonScreen(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBar(navController, title = "Morgons adhkar")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMorgonScreen() {
    Surface(color = colorResource(id = R.color.light_beige)) {
        MorgonScreen()
    }
}