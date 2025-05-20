package com.yavuzeroglu.todoapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.util.query
import com.yavuzeroglu.todoapp.databinding.FragmentHomeBinding
import com.yavuzeroglu.todoapp.ui.adapter.TaskAdapter
import com.yavuzeroglu.todoapp.ui.viewModel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.createFab.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCreateTaskFragment())
        }

        viewModel.taskList.observe(viewLifecycleOwner) {
            val taskAdapter = TaskAdapter(it, viewModel)
            binding.taskRV.adapter = taskAdapter
        }

        binding.taskRV.layoutManager = LinearLayoutManager(requireContext())


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe
                viewModel.searchTask(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Ara buttonuna basılınca
                viewModel.searchTask(query)
                return true
            }
        })


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTasks()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}