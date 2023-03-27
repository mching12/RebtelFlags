package com.android.rebtelflags.ui.compose

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.R
import com.android.rebtelflags.countrydetails.CountryDetailsActivity
import com.android.rebtelflags.data.model.Country


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun gridView(context: Context,
             flagList: List<Country>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(0.dp)
    ) {
        items(flagList.size) {
            Card(onClick = {
                    CountryDetailsActivity.launch(context, flagList[it])
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
                    flagPhoto(country = flagList[it],
                        placeholderImg = R.drawable.img_placeholder,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp)
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(text = flagList[it].name?.common ?: "",
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}