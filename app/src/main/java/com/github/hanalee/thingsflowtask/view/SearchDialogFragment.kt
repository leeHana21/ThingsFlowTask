package com.github.hanalee.thingsflowtask.view

import android.os.Bundle
import android.view.*
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.DialogFragment
import com.github.hanalee.thingsflowtask.databinding.SearchDialogBinding
import com.github.hanalee.thingsflowtask.extension.toToast

class SearchDialogFragment : DialogFragment() {
    private lateinit var binding: SearchDialogBinding
    private lateinit var customDialogListener: CustomDialogListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchDialogBinding.inflate(layoutInflater)
        val view = binding.root

        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        //dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    override fun onResume() {
        super.onResume()
        val params: LayoutParams = dialog!!.window!!.attributes
        params.width = LayoutParams.MATCH_PARENT
        params.height = LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    private fun initView() = with(binding) {
        btSearch.setOnClickListener {
            if (etOrg.text.isNotEmpty() && etRepo.text.isNotEmpty()) {
                customDialogListener.setSearchKeyword(etOrg.text.toString(), etRepo.text.toString())
                dialog?.dismiss()
            } else {
                requireActivity().toToast("모두 입력하세요.")
            }
        }
    }

    interface CustomDialogListener {
        fun setSearchKeyword(org: String, repo: String)
    }

    fun setDialogListener(dialogListener: CustomDialogListener) {
        customDialogListener = dialogListener
    }
}