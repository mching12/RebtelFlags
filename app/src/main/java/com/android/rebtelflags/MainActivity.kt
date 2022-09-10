package com.android.rebtelflags

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.android.rebtelflags.ui.compose.gridView
import com.android.rebtelflags.ui.model.GridItem
import com.android.rebtelflags.ui.theme.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    val dataset: List<GridItem> = listOf(
        GridItem("Anderson", "https://countryflagsapi.com/png/ad"),
        GridItem("Bisping", "https://countryflagsapi.com/png/ae"),
        GridItem("Chuck", "https://countryflagsapi.com/png/af"),
        GridItem("Dodson", "https://countryflagsapi.com/png/ag"),
        GridItem("Elephant", "https://countryflagsapi.com/png/ai"),
        GridItem("Figureido", "https://countryflagsapi.com/png/al"),
        GridItem("Gorilla", "https://countryflagsapi.com/png/am"),
        GridItem("Holly", "https://countryflagsapi.com/png/be"),
        GridItem("Iran", "https://countryflagsapi.com/png/bf"),
        GridItem("Joana", "https://countryflagsapi.com/png/bg"),
        GridItem("Karolina", "https://countryflagsapi.com/png/bh"),
        GridItem("Lemon", "https://countryflagsapi.com/png/ma"),
        GridItem("Mark", "https://countryflagsapi.com/png/mc"),
        GridItem("Nunes", "https://countryflagsapi.com/png/md"),
        GridItem("Oliveira", "https://countryflagsapi.com/png/me"),
        GridItem("Paddy", "https://countryflagsapi.com/png/mf"),
        GridItem("Qatar", "https://countryflagsapi.com/png/mg"),
        GridItem("Ronda", "https://countryflagsapi.com/png/mh"),
        GridItem("Stephen", "https://countryflagsapi.com/png/mk"),
        GridItem("Tai", "https://countryflagsapi.com/png/ml"),
        GridItem("Undertaker", "https://countryflagsapi.com/png/mm"),
        GridItem("Viera", "https://countryflagsapi.com/png/mn")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RebtelFlagsTheme {
                // on below line we are specifying
                // background color for our application
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // on below line we are specifying theme as scaffold.
                    Scaffold(
                        // in scaffold we are specifying top bar.
                        topBar = {
                            // inside top bar we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,
                                // along with that we are specifying title for our top bar.
                                title = {
                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "Grid View Example",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying color for our text.
                                        color = Color.White
                                    )
                                }
                            )
                        }
                    ) { padding ->
                        // Simulate a fake 2-second 'load'. Ideally this 'refreshing' value would
                        // come from a ViewModel or similar
                        var refreshing by remember { mutableStateOf(false) }
                        LaunchedEffect(refreshing) {
                            if (refreshing) {
                                delay(2000)
                                refreshing = false
                            }
                        }

                        SwipeRefresh(
                            state = rememberSwipeRefreshState(isRefreshing = refreshing),
                            onRefresh = { refreshing = true },
                        ) {
                            // on below line we are calling grid
                            // view method to load our grid view.
                            gridView(context = LocalContext.current,
                                list = dataset,
                                placeHolderImgRes = placeholderImg)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val placeholderImg = R.drawable.img_placeholder
    }
}