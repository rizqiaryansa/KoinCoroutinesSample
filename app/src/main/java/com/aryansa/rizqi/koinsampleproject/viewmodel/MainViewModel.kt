package com.aryansa.rizqi.koinsampleproject.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.aryansa.rizqi.koinsampleproject.model.UserModel
import com.aryansa.rizqi.koinsampleproject.repository.Repository
import com.aryansa.rizqi.koinsampleproject.utils.ApiObserver
import com.aryansa.rizqi.koinsampleproject.utils.await
import com.aryansa.rizqi.koinsampleproject.utils.isOnline
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainViewModel(private val repository: Repository, private val app: Application):
        AndroidViewModel(app) {

    var listDataUserGithub : MutableLiveData<UserModel> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getUserGithub(name: String?) {
        if(app.isOnline()) name?.let { loadUserGithub(it) }
    }

    private fun loadUserGithub(name: String?) {
//        launch(UI) {
//            val getDataUserGithub = name?.let { repository.getUserGithub(it).await() }
//            listDataUserGithub.value = getDataUserGithub
//        }

        name?.let { repository.getUserGithub(it).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : ApiObserver<UserModel>(compositeDisposable) {
                    override fun onApiSuccess(data: UserModel) {
                        listDataUserGithub.value = data
                    }

                    override fun onApiError(er: Throwable) {
                        error.value = er
                    }
                }) }
    }
}