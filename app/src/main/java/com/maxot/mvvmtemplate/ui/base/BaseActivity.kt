package com.maxot.mvvmtemplate.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.maxot.mvvmtemplate.util.FragmentUtil


abstract class BaseActivity<T: BaseViewModel, V : ViewDataBinding> : FragmentActivity() {

    lateinit var mViewDataBinding: V
    lateinit var mViewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }


    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): T

    abstract fun getBindingVariable(): Int

//     fun getViewDataBinding(): V{
//         return mViewDataBinding
//    }


    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), getViewModel())
        mViewDataBinding.executePendingBindings()
    }

    fun replaceFragment(fragment: Fragment){
        FragmentUtil.replaceFragment(supportFragmentManager,fragment, false)
    }

}