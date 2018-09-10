package com.aryansa.rizqi.koinsampleproject

import android.app.Application
import com.aryansa.rizqi.koinsampleproject.di.mainVmModule
import com.aryansa.rizqi.koinsampleproject.di.remoteDataSourceModule
import com.aryansa.rizqi.koinsampleproject.di.repositoryDataSourceModule
import org.koin.android.ext.android.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
                listOf(remoteDataSourceModule,
                        repositoryDataSourceModule,
                        mainVmModule))
    }
}