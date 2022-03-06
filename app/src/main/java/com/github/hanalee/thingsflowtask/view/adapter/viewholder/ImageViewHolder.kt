package com.github.hanalee.thingsflowtask.view.adapter.viewholder

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.hanalee.thingsflowtask.R
import com.github.hanalee.thingsflowtask.databinding.RecyclerviewImageItemBinding


class ImageViewHolder(private val binding: RecyclerviewImageItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val imageUrl =
        "https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png"
    private val websiteUrl = "https://thingsflow.com/ko/home"
    fun binds() {
        binding.apply {
            Glide.with(ivImage.context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .thumbnail(0.1f)
                .error(R.drawable.ic_launcher_foreground)
                .into(ivImage)
            
            ivImage.setOnClickListener {
                ivImage.context.startActivity(Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(websiteUrl)
                ))
            }
        }
    }
}