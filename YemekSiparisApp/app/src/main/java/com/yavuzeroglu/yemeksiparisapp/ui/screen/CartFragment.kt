package com.yavuzeroglu.yemeksiparisapp.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yavuzeroglu.yemeksiparisapp.R
import com.yavuzeroglu.yemeksiparisapp.databinding.FragmentCartBinding
import com.yavuzeroglu.yemeksiparisapp.ui.adapter.CartAdapter
import com.yavuzeroglu.yemeksiparisapp.ui.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.cartItemRv.layoutManager = LinearLayoutManager(requireContext())
        viewModel.itemList.observe(viewLifecycleOwner) {
            val adapter = CartAdapter(it, viewModel)
            binding.cartItemRv.adapter = adapter
            binding.orderButton.setText("Toplam: ${adapter.getTotalPrice()}₺")
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(CartFragmentDirections.actionCartFragmentToHomeFragment())
        }
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        viewModel.getCartItems("yavuz_eroglu")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}