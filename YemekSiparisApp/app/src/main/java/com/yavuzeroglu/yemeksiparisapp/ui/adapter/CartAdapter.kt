package com.yavuzeroglu.yemeksiparisapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yavuzeroglu.yemeksiparisapp.data.entity.CartItem
import com.yavuzeroglu.yemeksiparisapp.databinding.CartItemRecyclerBinding
import com.yavuzeroglu.yemeksiparisapp.ui.viewmodel.CartViewModel

class CartAdapter(var cartList: List<CartItem>, var viewModel: CartViewModel) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(var binding: CartItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val binding = CartItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        holder.binding.productName.text = cartList[position].yemek_adi
        holder.binding.quantityProductTextView.text = "adet: ${cartList[position].yemek_siparis_adet.toString()}"
        holder.binding.productPrice.text = "${cartList[position].yemek_fiyat.toString()}₺"

        Glide.with(holder.itemView.context)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${cartList[position].yemek_resim_adi}")
            .into(holder.binding.productImage)

        holder.binding.deleteImageView.setOnClickListener {
            viewModel.deleteCartItem(cartList[position].sepet_yemek_id.toInt(), "yavuz_eroglu")
        }
    }

    override fun getItemCount(): Int = cartList.size

    fun getTotalPrice(): Int {
        return cartList.sumOf { it.yemek_fiyat.toInt() * it.yemek_siparis_adet.toInt() }
    }
}