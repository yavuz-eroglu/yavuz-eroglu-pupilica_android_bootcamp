package com.yavuzeroglu.getircloneprojecthomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yavuzeroglu.getircloneprojecthomework.databinding.ItemSlideBinding

class SliderAdapter(val images: List<Int>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(var binding: ItemSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderViewHolder {
        val binding = ItemSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SliderViewHolder,
        position: Int
    ) {
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}