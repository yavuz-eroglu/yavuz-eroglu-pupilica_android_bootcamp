package com.yavuzeroglu.yemeksiparisapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yavuzeroglu.yemeksiparisapp.data.entity.Yemek
import com.yavuzeroglu.yemeksiparisapp.databinding.FoodRecyclerItemBinding
import com.yavuzeroglu.yemeksiparisapp.ui.screen.HomeFragmentDirections
import com.yavuzeroglu.yemeksiparisapp.ui.viewmodel.HomeViewModel

class YemekAdapter(var yemekList: List<Yemek>, var viewModel: HomeViewModel) :
    RecyclerView.Adapter<YemekAdapter.YemekViewHolder>() {

    inner class YemekViewHolder(var binding: FoodRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YemekViewHolder {
        val binding =
            FoodRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YemekViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: YemekViewHolder,
        position: Int
    ) {
        holder.binding.textViewFoodName.text = yemekList[position].yemek_adi
        holder.binding.textViewPrice.text = "${yemekList[position].yemek_fiyat.toString()} ₺"

        Glide.with(holder.itemView.context)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemekList[position].yemek_resim_adi}")
            .into(holder.binding.imageViewFood)

        holder.binding.imageViewFood.contentDescription = yemekList[position].yemek_adi

        holder.binding.foodCardView.setOnClickListener {
            Navigation.findNavController(it).navigate(
                HomeFragmentDirections.actionHomeFragmentToFoodDetailFragment(yemekList[position])
            )
        }

    }

    override fun getItemCount(): Int = yemekList.size


}