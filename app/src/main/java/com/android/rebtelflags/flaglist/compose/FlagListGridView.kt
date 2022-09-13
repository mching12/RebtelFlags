package com.android.rebtelflags.flaglist.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.R
import com.android.rebtelflags.ui.model.GridItem
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun gridView(context: Context,
             flagList: List<GridItem>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier.padding(0.dp)
    ) {
        items(flagList.size) {
            Card(onClick = {
                Toast.makeText(context,
                    flagList[it].label + " selected..",
                    Toast.LENGTH_SHORT
                ).show()
                },

                modifier = Modifier.padding(8.dp),
                elevation = 6.dp
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    GlideImage(
                        imageModel = flagList[it].imgUrl,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp),
                        placeHolder = ImageBitmap.imageResource(R.drawable.img_placeholder),
                        error = ImageBitmap.imageResource(R.drawable.img_placeholder)
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(text = flagList[it].label,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}