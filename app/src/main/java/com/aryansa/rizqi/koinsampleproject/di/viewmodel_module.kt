package com.aryansa.rizqi.koinsampleproject.di

import com.aryansa.rizqi.koinsampleproject.viewmodel.ItemMainViewModel
import com.aryansa.rizqi.koinsampleproject.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val mainVmModule = applicationContext {
    bean { MainViewModel(get(), androidApplication()) }
}