package com.android.rebtelflags.ui.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.R
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.ui.theme.RebtelFlagsTheme
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun flagPhoto(
    country: Country?,
    modifier: Modifier,
    contentScale: ContentScale,
    @DrawableRes placeholderImg: Int,
) {
    GlideImage(
        imageModel = country?.flags?.png,
        contentScale = contentScale,
        modifier = modifier,
        previewPlaceholder = placeholderImg,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RebtelFlagsTheme {
        flagPhoto(
            country = Country.getPhilippines(),
            modifier = Modifier.fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Fit,
            placeholderImg = R.drawable.img_placeholder
        )
    }
}