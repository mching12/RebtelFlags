package com.android.rebtelflags.ui.compose

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.android.rebtelflags.R
import com.android.rebtelflags.flaglist.FlagListEvent
import com.android.rebtelflags.flaglist.FlagListViewState
import com.android.rebtelflags.util.ext.toast

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FlagListContainer(
    context: Context,
    viewState: FlagListViewState?,
    isLoading: Boolean,
    onEvent: (FlagListEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = { TopAppBar(title = stringResource(R.string.home_screen_title)) }
        ) { innerPadding ->

            val pullRefreshState = rememberPullRefreshState(
                refreshing = isLoading,
                onRefresh = { onEvent(FlagListEvent.Refresh) }
            )

            Box(Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .pullRefresh(pullRefreshState)
            ) {
                //  handle UI states here
                //  observeAsState() is an livedata extension that makes it compatible with compose' observable
                when (viewState) {
                    is FlagListViewState.Empty ->
                        context.toast(stringResource(R.string.message_empty_data))
                    is FlagListViewState.Loaded ->
                        CountryGridView(
                            context = LocalContext.current,
                            flagList = viewState.data
                        )
                    is FlagListViewState.Error ->
                        context.toast(viewState.message ?: stringResource(R.string.error_generic))
                    else -> {}
                }

                PullRefreshIndicator(
                    refreshing = isLoading,
                    state = pullRefreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}