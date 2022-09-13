package com.android.rebtelflags.flaglist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.rebtelflags.data.FlagRepository
import kotlinx.coroutines.*

class FlagListViewModel (
    private val flagRepository: FlagRepository
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

    fun fetchFlags() {
        Log.d("testqwerty", "fetching flags...")
        _uiState.value = FlagListViewState.Loading
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = flagRepository.getFlags()
            withContext(Dispatchers.Main) {
                Log.d("testqwerty", "response set: ${response.size}")
                _uiState.value = FlagListViewState.Loaded(response)
//                if (response.isSuccessful) {
//                    movieList.postValue(response.body())
//                    loading.value = false
//                } else {
//                    onError("Error : ${response.message()} ")
//                }
            }
        }
    }
}