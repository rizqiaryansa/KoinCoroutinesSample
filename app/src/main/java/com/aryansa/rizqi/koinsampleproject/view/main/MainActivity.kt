package com.aryansa.rizqi.koinsampleproject.view.main

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import com.aryansa.rizqi.koinsampleproject.R
import com.aryansa.rizqi.koinsampleproject.databinding.ActivityMainBinding
import com.aryansa.rizqi.koinsampleproject.viewmodel.ItemMainViewModel
import com.aryansa.rizqi.koinsampleproject.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    private val mainVm: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ItemMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ItemMainViewModel()
        binding.repoUser = viewModel


        btnSearch.setOnClickListener {
            if (!isEmpty(edtUsername.text)) {
                mainVm.getUserGithub(edtUsername.text.toString())
                pbContainer.visibility = View.VISIBLE
            }
        }

        setUserGithub()
    }

    private fun setUserGithub() {
        mainVm.listDataUserGithub.observe(this, Observer { it ->
//            it?.let { ItemMainViewModel().showData(it) }
                it?.let {
                    viewModel.showData(it)
                }
            pbContainer.visibility = View.GONE
        })
    }


}
