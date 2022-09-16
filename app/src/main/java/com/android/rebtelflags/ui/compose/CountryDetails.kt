package com.android.rebtelflags.ui.compose

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun countryDetails(
    @StringRes label: Int,
    value: String?,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier =
        Modifier.fillMaxWidth()
            .padding(8.dp),
    ) {

        CompositionLocalProvider(
            LocalContentAlpha provides 1f
        ) {
            Text(text = stringResource(label),
                modifier =
                Modifier
                    .width(160.dp),
                style = MaterialTheme.typography.h6
            )
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = value ?: "",
                style = MaterialTheme.typography.h6
            )
        }
    }
}