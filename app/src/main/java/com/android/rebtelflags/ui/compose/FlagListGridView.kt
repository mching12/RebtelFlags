package com.android.rebtelflags.ui.compose

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.countrydetails.CountryDetailsActivity
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.ui.theme.RebtelFlagsTheme

@Composable
fun CountryGridView(context: Context,
                    flagList: List<Country>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(0.dp)
    ) {
        items(flagList.size) {
            val country = flagList[it]
            CountryGridItem (
                country = country,
                action = { CountryDetailsActivity.launch(context, country) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryGridViewPreview() {
    RebtelFlagsTheme {
        CountryGridView(
            context = LocalContext.current,
            flagList = Country.getCountryList()
        )
    }
}