package com.android.rebtelflags.flaglist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.model.Result
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class FlagListViewModel (
    private val countryRepository: CountryRepository
) : ViewModel() {

    private var _uiState = MutableLiveData<FlagListViewState>(FlagListViewState.Empty)
    var uiState: LiveData<FlagListViewState> = _uiState

    init {
        fetchFlags()
    }

    private fun onErrorOccurred(error: String?) {
        _uiState.value = FlagListViewState.Error(error)
    }

    fun fetchFlags() {
        Log.d("testqwerty", "fetching flags...")
        _uiState.value = FlagListViewState.Loading
        viewModelScope.launch {
            countryRepository.fetchCountries().collect() {
                when (it.status) {
                    Result.Status.SUCCESS -> {
                        _uiState.value =
                            if (it.data?.isNotEmpty() == true)
                                FlagListViewState.Loaded(it.data)
                            else FlagListViewState.Empty
                    }
                    Result.Status.ERROR -> onErrorOccurred(it.message)
                    else -> {}
                }
            }
        }
    }
}