package com.aryansa.rizqi.koinsampleproject.di

import com.aryansa.rizqi.koinsampleproject.repository.Repository
import org.koin.dsl.module.applicationContext

val repositoryDataSourceModule = applicationContext {
    bean { Repository(get()) }
}