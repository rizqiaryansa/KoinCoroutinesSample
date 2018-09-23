package com.aryansa.rizqi.koinsampleproject.repository.api

import com.aryansa.rizqi.koinsampleproject.model.RepoModel
import com.aryansa.rizqi.koinsampleproject.model.UserModel
import io.reactivex.Observable
import retrofit2.Call

interface ApiDataSource {

    fun getRepoUserGithub(name: String): Observable<UserModel>
    fun getListRepo(name: String): Call<RepoModel>
}