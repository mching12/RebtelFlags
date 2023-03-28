package com.android.rebtelflags.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.R

@Composable
fun countryDetailsContainer(
    country: Country?
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = { topAppBar( country?.name?.official ?: "") }
        ) {
            Box (
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    flagPhoto(country = country,
                        modifier = Modifier.fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit,
                        placeholderImg = R.drawable.img_placeholder
                    )
                    countryDetails(label = R.string.label_name, value = country?.name?.common)
                    countryDetails(label = R.string.label_cca2, value = country?.cca2)
                    countryDetails(label = R.string.label_cca3, value = country?.cca3)
                    countryDetails(label = R.string.label_ccn3, value = country?.ccn3)
                    countryDetails(label = R.string.label_ccioc, value = country?.cioc)
                    countryDetails(label = R.string.label_independent, value = country?.independent.toString())
                    countryDetails(label = R.string.label_unMember, value = country?.unMember.toString())
                    countryDetails(label = R.string.label_region, value = country?.region)
                    countryDetails(label = R.string.label_sub_region, value = country?.subregion)
                }
            }
        }
    }
}