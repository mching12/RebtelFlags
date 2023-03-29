package com.android.rebtelflags.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.R
import com.android.rebtelflags.ui.theme.RebtelFlagsTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CountryDetailsContainer(
    country: Country?
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar( country?.name?.official ?: "")
        FlagPhoto(country = country,
            placeholderImg = R.drawable.img_placeholder)
        CountryDetails(label = R.string.label_name, value = country?.name?.common)
        CountryDetails(label = R.string.label_cca2, value = country?.cca2)
        CountryDetails(label = R.string.label_cca3, value = country?.cca3)
        CountryDetails(label = R.string.label_ccn3, value = country?.ccn3)
        CountryDetails(label = R.string.label_ccioc, value = country?.cioc)
        CountryDetails(label = R.string.label_independent, value = country?.independent.toString())
        CountryDetails(label = R.string.label_unMember, value = country?.unMember.toString())
        CountryDetails(label = R.string.label_region, value = country?.region)
        CountryDetails(label = R.string.label_sub_region, value = country?.subregion)
//    }
    }
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colors.background
//    ) {
//        Scaffold(
//            topBar = { topAppBar( country?.name?.official ?: "") }
//        ) {
//            Box (
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                ) {
//                    FlagPhoto(country = country,
//                        placeholderImg = R.drawable.img_placeholder)
//                    CountryDetails(label = R.string.label_name, value = country?.name?.common)
//                    CountryDetails(label = R.string.label_cca2, value = country?.cca2)
//                    CountryDetails(label = R.string.label_cca3, value = country?.cca3)
//                    CountryDetails(label = R.string.label_ccn3, value = country?.ccn3)
//                    CountryDetails(label = R.string.label_ccioc, value = country?.cioc)
//                    CountryDetails(label = R.string.label_independent, value = country?.independent.toString())
//                    CountryDetails(label = R.string.label_unMember, value = country?.unMember.toString())
//                    CountryDetails(label = R.string.label_region, value = country?.region)
//                    CountryDetails(label = R.string.label_sub_region, value = country?.subregion)
//                }
//            }
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun CountryDetailsPagePreview() {
    RebtelFlagsTheme {
        CountryDetailsContainer(country = Country.getPhilippines())
    }
}