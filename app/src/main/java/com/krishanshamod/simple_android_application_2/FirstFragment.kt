package com.krishanshamod.simple_android_application_2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.krishanshamod.simple_android_application_2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private var userEmail: String = ""
    private var userPassword: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.LoginButton.setOnClickListener {
            binding.apply {

                // Get the input from the user
                userEmail = LoginEmail.text.toString()
                userPassword = LoginPassword.text.toString()

                if(userEmail=="" || userPassword=="") {
                    // Show enter again msg if user doesn't input anything
                    binding.textView2.text = "Please enter the Email and Password"
                } else {
                    //get and set data in Shared Preferences
                    var sharedPreferences = requireContext().getSharedPreferences("SharedPrefFile", Context.MODE_PRIVATE)
                    var editor = sharedPreferences.edit()

                    val savedEmail = sharedPreferences.getString("Email",null)
                    val savedPassword = sharedPreferences.getString("Password",null)

                    // check the email and password correct or not
                    if(userEmail==savedEmail && userPassword==savedPassword) {

                        editor.apply() {
                            putBoolean("LoggedIn", LoginSwitch.isChecked)
                        }.apply()

                        // Navigate to the Home screen
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

                    } else {
                        binding.textView2.text = "Email or Password incorrect"
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}