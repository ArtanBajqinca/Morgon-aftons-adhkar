package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.viewModel.TextOptionsViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerContentAdhkarScreen(
    navController: NavController,
    drawerState: DrawerState,
    viewModel: TextOptionsViewModel,
    coroutineScope: CoroutineScope
) {
    val context = LocalContext.current
    ModalDrawerSheet(
        drawerShape = RectangleShape,
    ) {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.extra_dark_beige))
        ) {
            Box (
                modifier = Modifier
                    .width(240.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.islamic_graphic_bg),
                    contentDescription = "Settings Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(240.dp),
                ) {
                    Spacer(modifier = Modifier.height(65.dp))

                    Image(
                        painter = painterResource(id = R.drawable.morgon_afton_logo),
                        contentDescription = "Morgon Afton Logo",
                        modifier = Modifier
                            .width(126.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Version 1.0",
                        color = colorResource(id = R.color.light_beige),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(37.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 8.dp)
                                .background(
                                    color = colorResource(id = R.color.light_beige),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = "Text inställning",
                                modifier = Modifier
                                    .padding(top = 4.dp),
                                color = colorResource(id = R.color.extra_dark_beige),
                                style = TextStyle(
                                    fontFamily = AvenirFontFamily,
                                    fontWeight = FontWeight.W600,
                                    fontSize = 19.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        SettingsTextAndCheckmark(
                            text = "Svenska",
                            initiallyTicked = viewModel.showTranslation,
                            onCheckedChange = { isChecked ->
                                // Handle checkmark state change
                                viewModel.setTranslationVisibility(isChecked, context)
                                println("Checkmark is now: ${if (isChecked) "ticked" else "unticked"}")
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        SettingsTextAndCheckmark(
                            text = "Transliteration",
                            initiallyTicked = viewModel.showTransliteration,

                            onCheckedChange = { isChecked ->
                                // Handle checkmark state change
                                viewModel.setTransliterationVisibility(isChecked, context)
                                println("Checkmark is now: ${if (isChecked) "ticked" else "unticked"}")
                            }
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        SettingsTextAndCheckmark(
                            text = "Arabiska",
                            initiallyTicked = viewModel.showArabic,
                            onCheckedChange = { isChecked ->
                                // Handle checkmark state change
                                viewModel.setArabicVisibility(isChecked, context)
                                println("Checkmark is now: ${if (isChecked) "ticked" else "unticked"}")
                            }
                        )

                    }
                }
            }
        }
    }
}