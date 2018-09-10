package com.aryansa.rizqi.koinsampleproject

import com.aryansa.rizqi.koinsampleproject.di.mainVmModule
import com.aryansa.rizqi.koinsampleproject.di.remoteDataSourceModule
import com.aryansa.rizqi.koinsampleproject.repository.Repository
import com.aryansa.rizqi.koinsampleproject.repository.api.ApiDataSource
import com.aryansa.rizqi.koinsampleproject.utils.await
import kotlinx.coroutines.experimental.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.test.KoinTest

class ApiTest: KoinTest {
    val repository: Repository by inject()

    @Before
    fun before(){
        StandAloneContext.startKoin(listOf(remoteDataSourceModule, remoteDataSourceModule, mainVmModule))
    }

    @After
    fun after(){
        StandAloneContext.closeKoin()
    }

    @Test
    fun testProfile() {
        launch {
            val profileCall = repository.getUserGithub("rizqiaryansa")
            profileCall.await()
        }
    }
}