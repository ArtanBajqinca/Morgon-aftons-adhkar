package artan.bajqinca.morgon_afton_dhikr.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.navigation.Navigation
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = TextOptionsViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorResource(id = R.color.light_beige)
            ) {
                Navigation(viewModel)
            }
        }
    }
}
