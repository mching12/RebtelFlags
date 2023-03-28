package com.android.rebtelflags.flaglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.rebtelflags.ui.compose.flagListContainer
import com.android.rebtelflags.ui.theme.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlagListActivity : ComponentActivity() {

    private val viewModel: FlagListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RebtelFlagsTheme {
                flagListContainer(
                    context = this@FlagListActivity,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RebtelFlagsTheme {
        Greeting(name = "Cark")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello! my name is $name",
        color = Color.Red,
        fontSize = 40.sp,
        modifier =
            Modifier
                .background(Color.Gray)
                .padding(all = 10.dp)
    )
}

