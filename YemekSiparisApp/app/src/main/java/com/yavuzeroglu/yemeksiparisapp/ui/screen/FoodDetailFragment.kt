package com.yavuzeroglu.yemeksiparisapp.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.yavuzeroglu.yemeksiparisapp.databinding.FragmentFoodDetailBinding
import com.yavuzeroglu.yemeksiparisapp.ui.viewmodel.FoodDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailFragment : Fragment() {
    private var _binding: FragmentFoodDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FoodDetailViewModel

    var quantity = 1
    var totalPrice = 0
    val bundle: FoodDetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempVM: FoodDetailViewModel by viewModels()
        viewModel = tempVM
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodDetailBinding.inflate(inflater, container, false)

        binding.timeChip.isClickable = false
        binding.starChip.isClickable = false


        val food = bundle.food

        binding.apply {
            // Food Image
            Glide.with(requireContext())
                .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}")
                .into(foodImageView)

            foodNameTextView.text = food.yemek_adi.toString()
            foodPriceTextView.text = food.yemek_fiyat.toString()

            // Back pressed
            backImageView.setOnClickListener {
                findNavController().popBackStack()
            }

            // başlangıçta quantity değerini atama
            quantityTextView.text = quantity.toString()

            // başlangıçta totalPrice değerini atama
            totalPrice = quantity * food.yemek_fiyat
            totalPriceTextView.text = totalPrice.toString()
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            plusButton.setOnClickListener {
                if (quantity < 99) {
                    quantity++
                    quantityTextView.text = quantity.toString()

                    totalPrice = quantity * bundle.food.yemek_fiyat
                    totalPriceTextView.text = totalPrice.toString()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Maximum sipariş adetine ulaştınız.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            minusButton.setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    quantityTextView.text = quantity.toString()

                    totalPrice = quantity * bundle.food.yemek_fiyat
                    totalPriceTextView.text = totalPrice.toString()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Minimum sipariş adetine ulaştınız.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            // Add To Cart
            addToCartButton.setOnClickListener {
                val yemekAdi = bundle.food.yemek_adi
                val yemekResimAdi = bundle.food.yemek_resim_adi
                val yemekFiyat = bundle.food.yemek_fiyat
                val yemekSiparisAdet = quantity
                val kullaniciAdi = "yavuz_eroglu"
                viewModel.addToCart(
                    yemekAdi,
                    yemekResimAdi,
                    yemekFiyat,
                    yemekSiparisAdet,
                    kullaniciAdi
                )

                Toast.makeText(
                    requireContext(),
                    "Ürün başarıyla sepete eklendi.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}