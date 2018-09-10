package com.aryansa.rizqi.koinsampleproject.repository.api


class ApiDataSourceImpl(private val apiService: ApiService): ApiDataSource {

    override fun getRepoUserGithub(name: String) = apiService.getUserGithub(name)

    override fun getListRepo(name: String) = apiService.getRepoGithub(name)

}