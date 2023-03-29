package com.android.rebtelflags.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.android.rebtelflags.ui.theme.greenColor

@Composable
fun TopAppBar(
    title: String
) {
    TopAppBar(backgroundColor = greenColor,
        title = {
            Text(text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    )
}