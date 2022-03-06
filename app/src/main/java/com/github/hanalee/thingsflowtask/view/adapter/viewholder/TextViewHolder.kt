package com.github.hanalee.thingsflowtask.view.adapter.viewholder

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.github.hanalee.thingsflowtask.databinding.RecyclerviewTextItemBinding
import com.github.hanalee.thingsflowtask.domain.retrofit.entity.response.IssueResponse
import com.github.hanalee.thingsflowtask.view.IssueDetailActivity


class TextViewHolder(private val binding: RecyclerviewTextItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun binds(item: IssueResponse.IssueItem) {
        binding.apply {
            val issuesInfo = "#${item.number} : ${item.title}"
            tvIssue.text = issuesInfo
            tvIssue.setOnClickListener {
                val intent = Intent(tvIssue.context, IssueDetailActivity::class.java)
                intent.putExtra("item", item)
                tvIssue.context.startActivity(intent)
            }
        }
    }
}