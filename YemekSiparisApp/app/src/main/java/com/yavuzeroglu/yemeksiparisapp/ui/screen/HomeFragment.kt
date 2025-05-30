package com.yavuzeroglu.yemeksiparisapp.ui.screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yavuzeroglu.yemeksiparisapp.R
import com.yavuzeroglu.yemeksiparisapp.databinding.FragmentHomeBinding
import com.yavuzeroglu.yemeksiparisapp.ui.adapter.YemekAdapter
import com.yavuzeroglu.yemeksiparisapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.foodRv.layoutManager = GridLayoutManager(context, 2)
        viewModel.yemekList.observe(viewLifecycleOwner) {
            val adapter = YemekAdapter(it, viewModel)
            binding.foodRv.adapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomAppBar.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.cart -> CartFragment()
                else -> HomeFragment()
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit()

            true
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoods()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}