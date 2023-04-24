package com.android.rebtelflags.countrydetails

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.ui.compose.CountryDetailsContainer
import com.android.rebtelflags.ui.theme.RebtelFlagsTheme
import com.android.rebtelflags.util.ext.intent
import com.android.rebtelflags.util.ext.parcelable

class CountryDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RebtelFlagsTheme {
                CountryDetailsContainer(country = intent.parcelable(EXTRA_BUNDLE))
            }
        }
    }

    companion object {
        private const val EXTRA_BUNDLE = "extra_bundle"

        fun launch(context: Context, country: Country) {
            context.intent<CountryDetailsActivity> {
                this.putExtra(EXTRA_BUNDLE, country)
            }.also {
                context.startActivity(it)
            }
        }
    }
}