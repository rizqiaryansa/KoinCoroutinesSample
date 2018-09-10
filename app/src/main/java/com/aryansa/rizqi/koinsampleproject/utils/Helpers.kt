package com.aryansa.rizqi.koinsampleproject.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aryansa.rizqi.koinsampleproject.model.RepoModel
import com.aryansa.rizqi.koinsampleproject.model.UserModel

data class ApiListRepository(val listRepo: RepoModel)

fun Context.isOnline(): Boolean {
    val activeNetworkInfo: NetworkInfo? = (getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager).activeNetworkInfo
    return activeNetworkInfo?.isConnectedOrConnecting ?: false
}

fun ViewGroup.inflate(resId: Int): View = LayoutInflater.from(context).
        inflate(resId, this, false)

fun RecyclerView.addDivider(layoutManager: LinearLayoutManager) {
    addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}