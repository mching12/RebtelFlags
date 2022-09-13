package com.android.rebtelflags.flaglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.rebtelflags.flaglist.compose.flagListContainer
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