package com.github.hanalee.thingsflowtask.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.hanalee.thingsflowtask.R
import com.github.hanalee.thingsflowtask.databinding.ActivityIssueDetailBinding
import com.github.hanalee.thingsflowtask.domain.remote_source.entity.response.IssueResponse

class IssueDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIssueDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_issue_detail)
        initView()

    }

    private fun initView() = with(binding) {
        lifecycleOwner = this@IssueDetailActivity
        this.executePendingBindings()

        val item = intent.getParcelableExtra<IssueResponse.IssueItem>("item")
        issue = item

        this@IssueDetailActivity.title = "#${item!!.number}"

        Glide.with(ivProfile.context)
            .load(item.user!!.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .thumbnail(0.1f)
            .error(R.drawable.ic_launcher_foreground)
            .circleCrop()
            .into(ivProfile)
    }
}