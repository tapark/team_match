package com.teddy_park.team_match.base

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.teddy_park.team_match.BR


abstract class BaseDialogFragment<V : ViewDataBinding, VM : ViewModel> : DialogFragment() {

    lateinit var binding: V
    abstract val viewModel: VM
    abstract val layout: Int

    open var touchOutSideToDismiss = true

    open var dialogWidthScale = 0.85F // device width 기준 scale = dialog width
    open var dialogHeightScale = 0F // device width 기준 scale = dialog width

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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(touchOutSideToDismiss)
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSize()
        initView(savedInstanceState)
        addObserver()

    }

    abstract fun onBackPressed()

    abstract fun addObserver()

    abstract fun initView(savedInstanceState: Bundle?)


    open fun initSize() {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        activity?.let {
            val windowWidth = Resources.getSystem().displayMetrics.widthPixels
            val windowHeight = Resources.getSystem().displayMetrics.heightPixels

            if (dialogWidthScale > 0F) {
                binding.root.layoutParams.apply {
                    width = (windowWidth * dialogWidthScale).toInt()
                }
            }

            if (dialogHeightScale > 0F) {
                binding.root.layoutParams.apply {
                    width = (windowHeight * dialogHeightScale).toInt()
                }
            }
        }
    }

}