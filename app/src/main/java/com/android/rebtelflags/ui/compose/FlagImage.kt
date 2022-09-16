package com.android.rebtelflags.ui.compose

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import com.android.rebtelflags.data.model.Country
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
        placeHolder = ImageBitmap.imageResource(placeholderImg),
    )
}