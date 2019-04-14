package com.maxot.mvvmtemplate.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.maxot.mvvmtemplate.BR
import com.maxot.mvvmtemplate.ui.adapter.RepositoryRecyclerViewAdapter
import com.maxot.mvvmtemplate.ui.base.BaseActivity
import com.maxot.mvvmtemplate.databinding.ActivityMainBinding
import com.maxot.mvvmtemplate.data.model.others.Repository
import android.arch.lifecycle.ViewModelProviders
import com.maxot.mvvmtemplate.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: BaseActivity<MainViewModel, ActivityMainBinding>(), RepositoryRecyclerViewAdapter.OnItemClickListener{

    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding ViewModel
        mViewDataBinding.viewModel = getViewModel()

        mViewDataBinding.repositoryRv.layoutManager = LinearLayoutManager(this)
        mViewDataBinding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        mViewModel.repositories.observe(this,
            Observer<ArrayList<Repository>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })

        refresh_button.setOnClickListener{
            replaceFragment(MainFragment())
        }
    }



    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return mViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

}
//
//
//class MainActivity : FragmentActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {
//
//
//    lateinit var binding: ActivityMainBinding
//    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//
//        binding.viewModel = viewModel
//        binding.executePendingBindings()
//
//        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
//        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
//        viewModel.repositories.observe(this,
//            Observer<ArrayList<Repository>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })
//
//    }
//
//    override fun onItemClick(position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}