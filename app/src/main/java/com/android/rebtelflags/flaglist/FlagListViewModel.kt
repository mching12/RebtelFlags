package com.android.rebtelflags.flaglist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.model.Result
import kotlinx.coroutines.*

class FlagListViewModel (
    private val countryRepository: CountryRepository
) : ViewModel() {

//    A.
//    If exposed stated is only being consumed by Composables, then it would be better
//    to simply use State:
//    var uiState = mutableStateOf(FlagListViewState.Empty)
//        private set
//    However, I find this approach a bit limited as it limits your usage
//    in consuming the UI state to only compose

//    B.
//    Alternatively, if source is a hot flow that isn't doing heavy work (like observing gps),
//    then it could be better to use Flow and write to State:
//
//    var uiState by mutableStateOf(FlagListViewState.Loading)
//        private set
//    init {
//        viewModelScope.launch {
//            <coldFlowSource>
//                .onEach { state = it }
//                .launchIn(viewModelScope)
//        }
//    }

    var uiState = MutableLiveData<FlagListViewState>(FlagListViewState.Empty)
        private set

    init {
        fetchFlags()
    }

    fun isLoading() = uiState.value is FlagListViewState.Loading

    private fun onErrorOccurred(error: String?) {
        uiState.value = FlagListViewState.Error(error)
    }

    fun fetchFlags() {
        uiState.value = FlagListViewState.Loading
        viewModelScope.launch {
            countryRepository.fetchCountries().run {
                when (status) {
                    Result.Status.SUCCESS -> {
                        uiState.value =
                            if (data?.isNotEmpty() == true)
                                FlagListViewState.Loaded(data)
                            else FlagListViewState.Empty
                    }
                    Result.Status.ERROR -> onErrorOccurred(message)
                    else -> {}
                }
            }
        }
    }
}