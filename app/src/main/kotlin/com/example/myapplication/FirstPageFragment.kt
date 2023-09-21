package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstPageBinding
import viewBinding

class FirstPageFragment: Fragment(R.layout.fragment_first_page) {
    private val binding by viewBinding(FragmentFirstPageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val action = FirstPageFragmentDirections.actionFirstPageFragmentToSecondPageFragment(
                "safe args test"
            )

            findNavController().navigate(action)
        }
    }
}