package com.maxot.mvvmtemplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<T: BaseViewModel, V : ViewDataBinding> : Fragment(){

    lateinit var mViewDataBinding: V
    lateinit var mViewModel: T


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.executePendingBindings()
        mViewModel = getViewModel()
        return mViewDataBinding.root
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): T

    abstract fun getBindingVariable(): Int

//    fun getViewDataBinding(): V{
//        return mViewDataBinding
//    }

}