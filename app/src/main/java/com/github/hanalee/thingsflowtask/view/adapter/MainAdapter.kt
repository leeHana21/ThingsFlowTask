package com.github.hanalee.thingsflowtask.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.hanalee.thingsflowtask.databinding.RecyclerviewImageItemBinding
import com.github.hanalee.thingsflowtask.databinding.RecyclerviewTextItemBinding
import com.github.hanalee.thingsflowtask.domain.retrofit.entity.response.IssueResponse
import com.github.hanalee.thingsflowtask.view.adapter.viewholder.ImageViewHolder
import com.github.hanalee.thingsflowtask.view.adapter.viewholder.TextViewHolder

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var issueList: IssueResponse
    private val imageViewType = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            imageViewType -> {
                ImageViewHolder(
                    RecyclerviewImageItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                TextViewHolder(
                    RecyclerviewTextItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> {
                holder.binds()
            }
            is TextViewHolder -> {
                holder.binds(issueList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return issueList.size
    }
    override fun getItemViewType(position: Int): Int {
        return if (position == 5) {
            imageViewType
        } else {
            super.getItemViewType(position)
        }
    }

    fun setData(data: IssueResponse) {
        issueList = data
        notifyDataSetChanged()
    }
}