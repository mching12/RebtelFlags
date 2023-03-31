package com.android.rebtelflags.flaglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.model.Result
import kotlinx.coroutines.*

class FlagListViewModel (
    private val countryRepository: CountryRepository
) : ViewModel() {

    private var _uiState = MutableLiveData<FlagListViewState>(FlagListViewState.Empty)
    var uiState: LiveData<FlagListViewState> = _uiState

    init {
        fetchFlags()
    }

    fun isLoading() = _uiState.value is FlagListViewState.Loading

    private fun onErrorOccurred(error: String?) {
        _uiState.value = FlagListViewState.Error(error)
    }

    fun fetchFlags() {
        _uiState.value = FlagListViewState.Loading
        viewModelScope.launch {
            countryRepository.fetchCountries().run {
                when (status) {
                    Result.Status.SUCCESS -> {
                        _uiState.value =
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