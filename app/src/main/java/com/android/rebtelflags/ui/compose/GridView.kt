package com.android.rebtelflags.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.ui.model.GridItem
import com.skydoves.landscapist.glide.GlideImage

// on below line we are creating grid view function for loading our grid view.
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun gridView(context: Context,
             list: List<GridItem> = listOf(),
             @DrawableRes placeHolderImgRes: Int
) {
    // on below line we are adding lazy
    // vertical grid for creating a grid view.
    LazyVerticalGrid(
        // on below line we are setting the
        // column count for our grid view.
        cells = GridCells.Fixed(3),
        // on below line we are adding padding
        // from all sides to our grid view.
        modifier = Modifier.padding(0.dp)
    ) {
        // on below line we are displaying our
        // items upto the size of the list.
        items(list.size) {
            // on below line we are creating a
            // card for each item of our grid view.
            Card(
                // inside our grid view on below line we are
                // adding on click for each item of our grid view.
                onClick = {
                    // inside on click we are displaying the toast message.
                    Toast.makeText(
                        context,
                        list[it].label + " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },

                // on below line we are adding padding from our all sides.
                modifier = Modifier.padding(8.dp),

                // on below line we are adding elevation for the card.
                elevation = 6.dp
            ) {
                // on below line we are creating a column on below sides.
                Column(
                    // on below line we are adding padding
                    // padding for our column and filling the max size.
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),

                    // on below line we are adding
                    // horizontal alignment for our column
                    horizontalAlignment = Alignment.CenterHorizontally,

                    // on below line we are adding
                    // vertical arrangement for our column
                    verticalArrangement = Arrangement.Center
                ) {
                    // on below line we are creating image for our grid view item.
                    GlideImage(
                        imageModel = list[it].imgUrl,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp),
                        placeHolder = ImageBitmap.imageResource(placeHolderImgRes),
                        // shows an error ImageBitmap when the request failed.
                        error = ImageBitmap.imageResource(placeHolderImgRes)
                    )

                    // on the below line we are adding a spacer.
                    Spacer(modifier = Modifier.height(9.dp))

                    // on below line we are creating
                    // a text for our grid view item
                    Text(
                        // inside the text on below line we are
                        // setting text as the language name
                        // from our modal class.
                        text = list[it].label,

                        // on below line we are adding padding
                        // for our text from all sides.
                        modifier = Modifier.padding(4.dp),

                        // on below line we are
                        // adding color for our text
                        color = Color.Black
                    )
                }
            }
        }
    }
}