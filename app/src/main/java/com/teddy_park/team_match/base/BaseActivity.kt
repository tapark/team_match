package com.teddy_park.team_match.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.teddy_park.team_match.BR
import androidx.lifecycle.ViewModel


abstract class BaseActivity<V : ViewDataBinding, VM : ViewModel>: AppCompatActivity() {

    lateinit var viewDataBinding: V
    abstract val viewModel: VM
    abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layout)
        viewDataBinding.setVariable(BR.viewModel, viewModel)
        viewDataBinding.lifecycleOwner = this

        addObserver()
        initView(savedInstanceState)
    }


    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)

}