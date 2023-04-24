package com.android.rebtelflags.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.ui.theme.RebtelFlagsTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountryGridItem(
    country: Country,
    action: () -> Unit
) {
    Card(onClick = action,
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
            FlagPhoto(country = country,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
                    .padding(3.dp)
            )

            Spacer(modifier = Modifier.height(9.dp))

            Text(text = country.name?.common ?: "",
                modifier = Modifier.padding(4.dp),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryGridItemPreview() {
    RebtelFlagsTheme {
        CountryGridItem(
            country = Country.getPhilippines(),
            action = {}
        )
    }
}