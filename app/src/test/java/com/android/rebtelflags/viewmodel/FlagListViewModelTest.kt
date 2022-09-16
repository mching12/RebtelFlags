package com.android.rebtelflags.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.rebtelflags.MainCoroutineRule
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.model.Country
import com.android.rebtelflags.data.model.Result
import com.android.rebtelflags.flaglist.FlagListViewModel
import com.android.rebtelflags.flaglist.FlagListViewState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FlagListViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var underTest: FlagListViewModel
    private val countryRepository = mockk<CountryRepository>(relaxed = true)

    @Before
    fun setUp() {
        underTest = FlagListViewModel(countryRepository)
    }

    @Test
    fun `Should expose loading when fetch is started`() {
        underTest.uiState.observeForever {}
        underTest.fetchFlags()
        underTest.uiState.value.run {
            assert(this != null)
            assert(this is FlagListViewState.Loading)
        }
    }

    @Test
    fun `Should expose Empty when fetched data is empty`() {
        //  mocks return of Status.Success, but empty data list
        coEvery { countryRepository.fetchCountries() } returns flow {
            emit(getResultData(Result.Status.SUCCESS))
        }
        underTest.uiState.observeForever {}
        underTest.fetchFlags()
        underTest.uiState.value.run {
            assert(this != null)
            assert(this is FlagListViewState.Empty)
        }
    }

    @Test
    fun `Should expose Error and errorMessage when fetching encounters an issue`() {
        //  mocks return of Status.Success, but empty data list
        val errorMessage = "Error...."
        coEvery { countryRepository.fetchCountries() } returns flow {
            emit(getResultData(status = Result.Status.ERROR, message = errorMessage))
        }
        underTest.uiState.observeForever {}
        underTest.fetchFlags()
        underTest.uiState.value.run {
            assert(this != null)
            assert(this is FlagListViewState.Error && this.message.equals(errorMessage))
        }
    }

    private fun getResultData(
        status: Result.Status,
        list: List<Country>? = null,
        message: String? = null
    ): Result<List<Country>> =
        Result(status = status,
            data = list,
            message = message
        )
}