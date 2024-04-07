package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import artan.bajqinca.morgon_afton_dhikr.R

@Composable
fun ImageBtn(
    image: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Image Button",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        )
    }
}

@Preview
@Composable
fun ImageBtnPreview() {
    ImageBtn(
        image = R.drawable.afton_image_btn,
        onClick = {}
    )
}