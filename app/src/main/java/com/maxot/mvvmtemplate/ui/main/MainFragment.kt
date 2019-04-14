package com.maxot.mvvmtemplate.ui.main

import android.arch.lifecycle.ViewModelProviders
import com.maxot.mvvmtemplate.BR
import com.maxot.mvvmtemplate.R
import com.maxot.mvvmtemplate.ui.base.BaseFragment
import com.maxot.mvvmtemplate.databinding.FragmentMainBinding

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(){


    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun getViewModel(): MainViewModel {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return mViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

}