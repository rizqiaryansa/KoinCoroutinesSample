package com.aryansa.rizqi.koinsampleproject.viewmodel

import android.databinding.ObservableField
import android.util.Log
import com.aryansa.rizqi.koinsampleproject.model.UserModel

class ItemMainViewModel {
    var name: ObservableField<String> = ObservableField()
    var avatarUrl: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()

    fun showData(model: UserModel){
        Log.d("result_debug","ItemMainViewModel # $model")
        this.name.set(model.name)
        this.location.set(model.location)
        this.avatarUrl.set(model.avatar_url)
    }
}