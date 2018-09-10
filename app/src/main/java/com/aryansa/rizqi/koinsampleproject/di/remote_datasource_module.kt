package com.aryansa.rizqi.koinsampleproject.di

import com.aryansa.rizqi.koinsampleproject.repository.api.*
import com.aryansa.rizqi.koinsampleproject.utils.BASE_URL
import org.koin.dsl.module.applicationContext

val remoteDataSourceModule = applicationContext {

    bean { createOkHttpClient() }
    bean { createWebService<ApiService>(get(), BASE_URL) }
    bean { ApiDataSourceImpl(get()) as ApiDataSource }
}