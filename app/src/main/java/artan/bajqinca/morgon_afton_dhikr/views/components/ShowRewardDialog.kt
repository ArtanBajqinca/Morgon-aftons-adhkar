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
                        color = colorResource(id = R.color.extra_dark_beige),
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

            // Ensure this is the last declared composable in the Box
            Box(
                modifier = Modifier
                    .offset { IntOffset(50, -50) }
                    .clip(RoundedCornerShape(100.dp))
                    .clickable { onDismiss() }
                    .background(
                        color = colorResource(id = R.color.dark_beige),
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