package com.yavuzeroglu.getircloneprojecthomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yavuzeroglu.getircloneprojecthomework.databinding.ItemCategoryBinding

class CategoryAdapter(val list: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(var binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val icon = binding.categoryIcon
        val title = binding.categoryTitle
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.binding.categoryIcon.setImageResource(item.imageRes)
        holder.binding.categoryTitle.text = item.name
    }

    override fun getItemCount() = list.size


}