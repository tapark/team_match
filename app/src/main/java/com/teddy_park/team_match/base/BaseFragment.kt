package com.teddy_park.team_match.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teddy_park.team_match.BR
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tapark.military_quest.base.BaseViewModel

abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel>: Fragment() {

    lateinit var binding: V
    abstract val viewModel: VM
    abstract val layout: Int

    private lateinit var backPressedCallback: OnBackPressedCallback

    override fun onStart() {
        super.onStart()
        backPressedCallback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPressedCallback)
    }

    override fun onStop() {
        super.onStop()
        backPressedCallback.remove()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserver()
        initView(savedInstanceState)
    }

    abstract fun onBackPressed()

    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)

}