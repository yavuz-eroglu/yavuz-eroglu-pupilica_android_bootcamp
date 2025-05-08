package com.yavuzeroglu.tasarmodeviiki

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yavuzeroglu.tasarmodeviiki.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val termsText = getString(R.string.terms_description)

        val spannableString = SpannableString(termsText)

        val grayColor = ContextCompat.getColor(requireContext(), R.color.on_surface)
        val blueColor = ContextCompat.getColor(requireContext(), R.color.primary)
        spannableString.setSpan(
            ForegroundColorSpan(grayColor),
            0, 46, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(blueColor),
            47, 60,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(grayColor),
            61, 65,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(blueColor),
            65, termsText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.termsTextView.text = spannableString
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()


            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToMoviesFragment(username)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}