package com.android.rebtelflags.ui.compose

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.android.rebtelflags.R
import com.android.rebtelflags.flaglist.FlagListViewModel
import com.android.rebtelflags.flaglist.FlagListViewState
import com.android.rebtelflags.util.ext.toast
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
            topBar = { TopAppBar(title = stringResource(R.string.home_screen_title)) }
        ) {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = viewModel.uiState.observeAsState().value is FlagListViewState.Loading),
                onRefresh = { viewModel.fetchFlags()}
            ) {
                //  handle UI states here
                when (val state = viewModel.uiState.observeAsState().value) {
                    is FlagListViewState.Empty -> context.toast(stringResource(R.string.message_empty_data))
                    is FlagListViewState.Loaded -> gridView(context = LocalContext.current, flagList = state.data)
                    is FlagListViewState.Error -> context.toast(state.message ?: stringResource(R.string.error_generic))
                    FlagListViewState.Loading -> {}
                    else -> {}
                }
            }
        }
    }
}