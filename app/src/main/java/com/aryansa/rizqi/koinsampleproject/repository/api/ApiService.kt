package com.aryansa.rizqi.koinsampleproject.repository.api

import com.aryansa.rizqi.koinsampleproject.model.RepoModel
import com.aryansa.rizqi.koinsampleproject.model.UserModel
import com.aryansa.rizqi.koinsampleproject.utils.ENDPOINT_REPO_USER
import com.aryansa.rizqi.koinsampleproject.utils.ENDPOINT_USER
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(ENDPOINT_USER)
    fun getUserGithub(@Path("username") username: String): Observable<UserModel>
    @GET(ENDPOINT_REPO_USER)
    fun getRepoGithub(@Path("username") username: String): Call<RepoModel>
}