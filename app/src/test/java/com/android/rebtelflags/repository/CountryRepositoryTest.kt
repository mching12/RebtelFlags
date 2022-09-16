package com.android.rebtelflags.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.rebtelflags.MainCoroutineRule
import com.android.rebtelflags.data.CountryRepository
import com.android.rebtelflags.data.local.CountryLocalDataSource
import com.android.rebtelflags.data.model.Result
import com.android.rebtelflags.data.remote.CountryRemoteDataSource
import com.android.rebtelflags.util.helper.ConnectivityHelper
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CountryRepositoryTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var underTest: CountryRepository
    private val local = mockk<CountryLocalDataSource>(relaxed = true)
    private val remote = mockk<CountryRemoteDataSource>(relaxed = true)
    private val connectivityHelper = mockk<ConnectivityHelper>(relaxed = true)

    @Before
    fun setUp() {
        underTest = CountryRepository(local, remote, connectivityHelper)
    }

    @Test
    fun `Should fetch local data when internet is not connected`() = runBlocking {
        val sampleEmptyData = Result(status = Result.Status.SUCCESS, data = null, message = null)
        //  we mock as if there's no connection
        every { connectivityHelper.isConnectedToNetwork() } returns false
        //  fetchAllCountries should then call 'local' instead of the default 'remote'
        coEvery { local.fetchAllCountries() } returns sampleEmptyData
        underTest.fetchCountries().collectLatest {
            //  return data should be equal to mocked response
            assert(it == sampleEmptyData)
        }
        coVerify { local.fetchAllCountries() }
    }
}