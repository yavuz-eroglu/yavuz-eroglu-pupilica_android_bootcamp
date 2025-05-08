package com.yavuzeroglu.tasarmodeviiki

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.yavuzeroglu.tasarmodeviiki.databinding.FragmentMoviesBinding


class MoviesFragment : Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = MoviesFragmentArgs.fromBundle(it).userName
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        if(username.isNullOrEmpty()) {
            username = "username"
        }

        // underline
        val spannableString = SpannableString(username)
        spannableString.setSpan(
            UnderlineSpan(),
            0,
            username.length,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.usernameTV.text = spannableString


        val categoryList = listOf(
            "Biographical" to 932,
            "Western" to 673,
            "Family" to 96,
            "Documentary" to 126,
            "Action" to 1096,
            "Fantasy" to 475,
            "Musical" to 398,
            "War" to 56,
            "Independent" to 49,
            "Crime" to 399,
            "Sci-fi" to 821,
            "Comedy" to 736
        )

        for ((categoryName, categoryCount) in categoryList) {
            val chip = Chip(requireContext())
            chip.text = "$categoryName ($categoryCount)"
            chip.isFocusable = true
            chip.isClickable = true
            chip.setChipBackgroundColorResource(R.color.primary)
            chip.setChipStrokeColorResource(R.color.on_secondary)
            chip.setTextColor(resources.getColor(R.color.tertiary))
            chip.textSize = 14f

            binding.categoryChipGroup.addView(chip)
        }

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}