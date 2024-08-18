package artan.bajqinca.morgon_afton_dhikr.views

import android.content.Intent
import android.net.Uri
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import java.util.Calendar
import android.content.pm.PackageManager
import android.util.Log

@Composable
fun InfoScreen(navController: NavController = rememberNavController()) {
    val context = LocalContext.current
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)

    // Get the app version dynamically
    val packageInfo = try {
        context.packageManager.getPackageInfo(context.packageName, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e("InfoScreen", "Package not found", e)
        null
    }
    val appVersion = packageInfo?.versionName ?: "1.0"  // Fallback to "1.0" if versionName is not found


    // Dialog state
    val showDialog = remember { mutableStateOf(false) }
    val dialogTitle = remember { mutableStateOf("") }
    val dialogMessage = remember { mutableStateOf("") }

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
                                    text = "Version $appVersion",  // Display the dynamic version
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
                                Spacer(modifier = Modifier.height(20.dp))

                                // Developer Information
                                Text(
                                    text = "Developer: Artan Bajqinca",
                                    color = colorResource(id = R.color.light_beige),
                                    style = TextStyle(
                                        fontFamily = AvenirFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Spacer(modifier = Modifier.height(30.dp))

                                // Privacy Policy Link
                                Box(
                                    modifier = Modifier
                                        .width(280.dp)
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(colorResource(id = R.color.light_beige))
                                        .clickable {
                                            // Show the dialog for Privacy Policy
                                            dialogTitle.value = "Privacy Policy"
                                            dialogMessage.value = "We respect your privacy. This app does not collect, store, or share any personal data. Your experience with the app is completely anonymous."
                                            showDialog.value = true
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Privacy Policy",
                                        style = TextStyle(
                                            fontFamily = AvenirFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            color = colorResource(id = R.color.gray)
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                // Terms of Service Link
                                Box(
                                    modifier = Modifier
                                        .width(280.dp)
                                        .height(30.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(colorResource(id = R.color.light_beige))
                                        .clickable {
                                            // Show the dialog for Terms of Service
                                            dialogTitle.value = "Terms of Service"
                                            dialogMessage.value = "We respect your privacy. This app does not collect, store, or share any personal data. Your experience with the app is completely anonymous."
                                            showDialog.value = true
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Terms of Service",
                                        style = TextStyle(
                                            fontFamily = AvenirFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            color = colorResource(id = R.color.gray)
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

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
                                    contentAlignment = Alignment.Center
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

                                // Copyright Information
                                Text(
                                    text = "© $currentYear Skyddad av upphovsrättslagen",
                                    color = colorResource(id = R.color.light_beige),
                                    style = TextStyle(
                                        fontFamily = AvenirFontFamily,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 14.sp
                                    ),
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )

                                Spacer(modifier = Modifier.height(40.dp))
                            }
                        }
                    }
                }
            }
        }
    }

    // Show the dialog if triggered
    if (showDialog.value) AlertDialog(
        onDismissRequest = { showDialog.value = false },
        title = {
            Text(
                text = dialogTitle.value,
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 23.sp,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.gray)
                )
            )
        },
        text = {
            Text(
                text = dialogMessage.value,
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontWeight = FontWeight.W600,
                    lineHeight = 23.sp,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.gray)
                )
            )
        },
        confirmButton = {
            Button(
                onClick = { showDialog.value = false },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.gray)
                )
            ) {
                Text(
                    text = "OK",
                    color = colorResource(id = R.color.light_beige)
                )
            }
        },
        shape = RoundedCornerShape(10.dp),
        containerColor = colorResource(id = R.color.light_beige)
    )
}

@Preview
@Composable
fun InfoScreenPreview() {
    InfoScreen()
}
