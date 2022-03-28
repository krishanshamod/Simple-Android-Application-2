package com.krishanshamod.simple_android_application_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.krishanshamod.simple_android_application_2.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.WelcomeRegisterButton.setOnClickListener {
            findNavController().navigate(R.id.action_FourthFragment_to_FirstFragment)
        }

        binding.WelcomeLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_FourthFragment_to_ThirdFragment)
        }
    }

}