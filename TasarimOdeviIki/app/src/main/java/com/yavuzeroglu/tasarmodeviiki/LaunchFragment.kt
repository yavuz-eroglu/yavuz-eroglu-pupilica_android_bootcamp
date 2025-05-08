package com.yavuzeroglu.tasarmodeviiki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yavuzeroglu.tasarmodeviiki.databinding.FragmentLaunchBinding


class LaunchFragment : Fragment() {
    private var _binding: FragmentLaunchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(LaunchFragmentDirections.actionLaunchFragmentToLoginFragment())
        }

        binding.signupButton.setOnClickListener {
            findNavController().navigate(
                LaunchFragmentDirections.actionLaunchFragmentToSignupFragment()
            )
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}