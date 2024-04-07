package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily

@Composable
fun ShowRewardDialog(
    rewardText: String,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            // add ribbon and text Belöning when i have time

//            Box(
//                modifier = Modifier
//                    .offset { IntOffset(-100, -70) }
//                    .clickable { onDismiss() }
//                    .align(Alignment.Center)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ribbon_icon),
//                    contentDescription = "ribbon icon",
//                    modifier = Modifier
//                        .size(100.dp) // Adjust the size as needed
//                )
//            }

            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = colorResource(id = R.color.light_beige),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = rewardText,
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .padding(horizontal = 10.dp, vertical = 26.dp),
                        color = colorResource(id = R.color.gray),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontWeight = FontWeight.W600,
                            lineHeight = 23.sp,
                            fontSize = 18.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            Box(
                modifier = Modifier
                    .offset { IntOffset(50, -50) }
                    .clip(RoundedCornerShape(100.dp))
                    .clickable { onDismiss() }
                    .background(
                        color = colorResource(id = R.color.gray),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.x),
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(24.dp) // Adjust the size as needed
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowRewardDialogPreview() {
    ShowRewardDialog(
        rewardText = "This is a reward text and is just a preview. For the actual reward text, please use the app.",
        onDismiss = {}
    )
}