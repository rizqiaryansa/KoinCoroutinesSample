package com.aryansa.rizqi.koinsampleproject.repository.api

import com.aryansa.rizqi.koinsampleproject.model.RepoModel
import com.aryansa.rizqi.koinsampleproject.model.UserModel
import retrofit2.Call

interface ApiDataSource {

    fun getRepoUserGithub(name: String): Call<UserModel>
    fun getListRepo(name: String): Call<RepoModel>
}