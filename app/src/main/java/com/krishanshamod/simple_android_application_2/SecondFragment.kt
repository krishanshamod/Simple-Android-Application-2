package com.krishanshamod.simple_android_application_2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.krishanshamod.simple_android_application_2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get and set data in Shared Preferences
        var sharedPreferences = requireContext().getSharedPreferences("SharedPrefFile", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        val savedName = sharedPreferences.getString("Name",null)

        // Set user's name in text view
        binding.NameView.text = savedName

        binding.LogoutButton.setOnClickListener {

            // Set LoggedIn value to false
            editor.apply() {
                putBoolean("LoggedIn", false)
            }.apply()

            // Navigate to Welcome Screen
            findNavController().navigate(R.id.action_SecondFragment_to_FourthFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}