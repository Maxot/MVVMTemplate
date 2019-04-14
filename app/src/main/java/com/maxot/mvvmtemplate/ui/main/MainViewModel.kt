package com.maxot.mvvmtemplate.ui.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.maxot.mvvmtemplate.ui.base.BaseViewModel
import com.maxot.mvvmtemplate.data.model.OnRepositoryReadyCallback
import com.maxot.mvvmtemplate.data.model.RepoModel
import com.maxot.mvvmtemplate.data.model.others.Repository

class MainViewModel : BaseViewModel(){
    var repoModel: RepoModel = RepoModel()

    val text = ObservableField("old data")

    val isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}