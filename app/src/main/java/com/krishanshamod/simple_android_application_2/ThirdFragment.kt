package com.krishanshamod.simple_android_application_2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.krishanshamod.simple_android_application_2.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private var userEmail: String = ""
    private var userPassword: String = ""
    private var userName: String = ""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RegButton.setOnClickListener {

            binding.apply {

                // Get the input from the user
                userEmail = RegEmail.text.toString()
                userPassword = RegPassword.text.toString()
                userName = RegName.text.toString()


                // Show the error msg or store data
                if(userEmail=="" || userPassword=="" || userName=="") {
                    binding.textView3.text = "Please fill everything"
                } else {

                    //save data in Shared Preferences
                    var sharedPreferences = requireContext().getSharedPreferences("SharedPrefFile", Context.MODE_PRIVATE)
                    var editor = sharedPreferences.edit()

                    editor.apply() {
                        putString("Name", userName)
                        putString("Email", userEmail)
                        putString("Password", userPassword)
                        putBoolean("Registered", true)
                    }.apply()

                    //Navigate to login screen
                    findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
                }
            }
        }
    }


}