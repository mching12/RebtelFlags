package com.android.rebtelflags.flaglist.compose

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.android.rebtelflags.R
import com.android.rebtelflags.flaglist.FlagListViewModel
import com.android.rebtelflags.flaglist.FlagListViewState
import com.android.rebtelflags.ui.theme.greenColor
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun flagListContainer(
    context: Context,
    viewModel: FlagListViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(backgroundColor = greenColor,
                    title = {
                        Text(text = stringResource(R.string.home_screen_title),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                )
            }
        ) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = viewModel.uiState.observeAsState().value is FlagListViewState.Loading),
                onRefresh = { viewModel.fetchFlags()}
            ) {
                //  handle UI states here
                when (val state = viewModel.uiState.observeAsState().value) {
                    is FlagListViewState.Empty -> {}
                    is FlagListViewState.Loaded -> {
                        Log.d("testqwerty", "UI Loaded size: ${state.data.size}")
                        gridView(context = LocalContext.current, flagList = state.data)
                    }
                    is FlagListViewState.Error -> {}
                    FlagListViewState.Loading -> {
                        Log.d("testqwerty", "UI loading")
                    }
                }
            }
        }
    }
}