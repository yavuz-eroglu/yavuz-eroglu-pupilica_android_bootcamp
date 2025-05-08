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
import com.yavuzeroglu.tasarmodeviiki.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)


        val grayColor = ContextCompat.getColor(
            requireContext(), R.color.on_surface
        )
        val blueColor = ContextCompat.getColor(
            requireContext(), R.color.primary
        )

        val text = getString(R.string.already_have_an_account_sign_in)
        val spannableString = SpannableString(text)

        spannableString.setSpan(
            ForegroundColorSpan(grayColor),
            0, 24,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(blueColor),
            25, text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.alreadyAccountTV.text = spannableString
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.signupButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()

            findNavController().navigate(
                SignupFragmentDirections.actionSignupFragmentToGenreSelectionFragment(username)
            )
        }
    }


}