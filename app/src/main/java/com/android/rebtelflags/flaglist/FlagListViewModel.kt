package com.android.rebtelflags.flaglist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.rebtelflags.data.CountryRepository
import kotlinx.coroutines.*

class FlagListViewModel (
    private val countryRepository: CountryRepository
) : ViewModel() {

    private var _uiState = MutableLiveData<FlagListViewState>(FlagListViewState.Empty)
    var uiState: LiveData<FlagListViewState> = _uiState

    private var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    init {
        fetchFlags()
    }

    private fun onErrorOccurred(error: String?) {
        _uiState.value = FlagListViewState.Error(error)
    }

    fun fetchFlags() {
        Log.d("testqwerty", "fetching flags...")
        _uiState.value = FlagListViewState.Loading
        job = CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                try {
                    val response = countryRepository.fetchFlags()
                    if (response.isSuccessful) {
                        _uiState.value =
                            if (response.body()?.isEmpty() == true) FlagListViewState.Empty
                            else FlagListViewState.Loaded(response.body() ?: listOf())
                    } else onErrorOccurred(response.message())
                } catch (ex: Exception) {
                    onErrorOccurred(ex.localizedMessage)
                }
            }
        }
    }
}