package com.example.testwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class Splash_ScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash__screen, container, false)
        val button1 = view.findViewById<Button>(R.id.button)
        button1.setOnClickListener{
            findNavController().navigate(R.id.action_splash_ScreenFragment_to_loginFragment)
        }

        val button2 = view.findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            findNavController().navigate(R.id.action_splash_ScreenFragment_to_mainFragment)
        }

        return view
    }

}