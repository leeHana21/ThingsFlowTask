package com.github.hanalee.thingsflowtask.view

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.hanalee.thingsflowtask.databinding.ActivityMainBinding
import com.github.hanalee.thingsflowtask.domain.viewmodel.MainViewModel
import com.github.hanalee.thingsflowtask.extension.toGone
import com.github.hanalee.thingsflowtask.extension.toInvisible
import com.github.hanalee.thingsflowtask.extension.toVisible
import com.github.hanalee.thingsflowtask.utils.UtilFunction
import com.github.hanalee.thingsflowtask.view.adapter.MainAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val mainAdapter: MainAdapter by inject()

    private lateinit var searchDialogFragment: SearchDialogFragment

    private val searchKeyWordListener by lazy {
        object : SearchDialogFragment.CustomDialogListener {
            override fun setSearchKeyword(org: String, repo: String) {
                mainViewModel.searchWithKeyword(org, repo)
                binding.apply {
                    rvIssues.toInvisible()
                    pbLoading.toVisible()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initObserver()
        getIssueAtFirstTime()
    }

    private fun initView() = with(binding) {
        tvTitle.setOnClickListener {
            searchDialogFragment = SearchDialogFragment()
            searchDialogFragment.setDialogListener(searchKeyWordListener)
            searchDialogFragment.show(supportFragmentManager, null)
        }
    }

    private fun initObserver() = with(mainViewModel) {
        issueList.observe(this@MainActivity) {
            mainAdapter.setData(it.first)

            binding.apply {
                rvIssues.adapter = mainAdapter
                tvTitle.text = it.second
                rvIssues.toVisible()
                pbLoading.toGone()
            }
        }

        noData.observe(this@MainActivity) {
            if (it.first) {
                UtilFunction.showSimpleAlertCheckOnly(
                    this@MainActivity,
                    "${it.second}"
                ) { dialog: DialogInterface?, _: Int ->
                    setNoDataFlagAfterCheckFromUser()
                    dialog!!.dismiss()
                }
                binding.apply {
                    rvIssues.toVisible()
                    pbLoading.toGone()
                }
            }
        }
    }

    private fun setNoDataFlagAfterCheckFromUser() = mainViewModel.noDataFlagAfterCheckFromUser()

    private fun getIssueAtFirstTime() = mainViewModel.getIssuesAtFirstTime()

}


