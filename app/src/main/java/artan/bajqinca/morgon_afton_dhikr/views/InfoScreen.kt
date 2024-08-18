package artan.bajqinca.morgon_afton_dhikr.views

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.views.components.BackButton
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_beige)),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.islamic_graphic_bg),
            contentDescription = "Settings Background"
        )
        Column {
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
                modifier = Modifier.width(320.dp)
            ) {
                Spacer(modifier = Modifier.height(200.dp))

                LazyColumn {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(colorResource(id = R.color.gray))
                                .padding(top = 40.dp),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 30.dp, end = 30.dp),
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.morgon_afton_logo),
                                    contentDescription = "Logo",
                                    modifier = Modifier
                                        .height(100.dp)
                                        .align(Alignment.CenterHorizontally),
                                    contentScale = ContentScale.Fit
                                )
                                Text(
                                    text = "Version 1.0",
                                    color = colorResource(id = R.color.light_beige),
                                    style = TextStyle(
                                        fontFamily = AvenirFontFamily,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 18.sp
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(top = 15.dp)
                                )
                                Spacer(modifier = Modifier.height(40.dp))

                                // Add a clickable Text to show OSS Licenses
                                Box(
                                    modifier = Modifier
                                        .width(280.dp)
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(colorResource(id = R.color.light_beige))
                                        .clickable {
                                            val intent = Intent(context, OssLicensesMenuActivity::class.java)
                                            startActivity(context, intent, null)
                                        },
                                    contentAlignment = Alignment.Center // Centers the content inside the Box
                                ) {
                                    Text(
                                        text = "Open Source Licenses",
                                        style = TextStyle(
                                            fontFamily = AvenirFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            color = colorResource(id = R.color.gray)
                                        )
                                    )
                                }


                                Spacer(modifier = Modifier.height(40.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun InfoScreenPreview() {
    InfoScreen()
}
