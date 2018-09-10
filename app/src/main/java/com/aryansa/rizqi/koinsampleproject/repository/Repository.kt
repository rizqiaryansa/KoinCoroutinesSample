package com.aryansa.rizqi.koinsampleproject.repository

import com.aryansa.rizqi.koinsampleproject.repository.api.ApiDataSource

class Repository(private val apiDataSource: ApiDataSource) {

    fun getUserGithub(name: String) = apiDataSource.getRepoUserGithub(name)
    fun getListRepo(name: String) = apiDataSource.getListRepo(name)
}