package com.aryansa.rizqi.koinsampleproject.view.main

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.View
import com.aryansa.rizqi.koinsampleproject.R
import com.aryansa.rizqi.koinsampleproject.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    private val mainVm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch.setOnClickListener {
            if (!isEmpty(edtUsername.text)) {
                mainVm.getUserGithub(edtUsername.text.toString())
                pbContainer.visibility = View.VISIBLE
            }
        }

        setUserGithub()
    }

    private fun setUserGithub() {
        mainVm.listDataUserGithub.observe(this, Observer {
            Glide.with(this).load(it?.avatar_url).into(avatarUser)
            nameUser.text = it?.name
            locationUser.text = it?.location

            pbContainer.visibility = View.GONE
        })
    }


}
