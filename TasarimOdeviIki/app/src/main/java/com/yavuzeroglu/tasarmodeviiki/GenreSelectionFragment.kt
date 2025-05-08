package com.yavuzeroglu.tasarmodeviiki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.yavuzeroglu.tasarmodeviiki.databinding.FragmentGenreSelectionBinding


class GenreSelectionFragment : Fragment() {
    private var _binding: FragmentGenreSelectionBinding? = null
    private val binding get() = _binding!!
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = GenreSelectionFragmentArgs.fromBundle(it).userName
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenreSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupChipGroup()
        setupButton()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun setupChipGroup() {
        binding.chipGroup1.setOnCheckedStateChangeListener { group, checkIds ->
            updateSelectedCount(checkIds.size)
        }

        updateSelectedCount(binding.chipGroup1.checkedChipIds.size)
    }

    private fun GenreSelectionFragment.updateSelectedCount(selectedCount: Int) {
        binding.pickButton.text = when {
            selectedCount == 0 -> "Pick"
            selectedCount == 1 -> "1 genre selected"
            else -> "$selectedCount genres selected"
        }
    }

    private fun setupButton() {
        binding.pickButton.setOnClickListener {
            val selectedCount = binding.chipGroup1.checkedChipIds.size

            if (selectedCount == 0) {
                Toast.makeText(
                    requireContext(),
                    "Please select at least one genre",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val selectedGenres = getSelectedGenres()
                navigateToNextScreen()
            }
        }
    }

    private fun navigateToNextScreen() {
        findNavController().navigate(
            GenreSelectionFragmentDirections.actionGenreSelectionFragmentToMoviesFragment(
                username
            )
        )
    }

    private fun getSelectedGenres(): List<String> {
        return binding.chipGroup1.checkedChipIds.mapNotNull { chipId ->
            binding.chipGroup1.findViewById<Chip>(chipId)?.text?.toString()
        }
    }

}


