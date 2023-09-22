package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentDetailBinding
import viewBinding

class DetailFragment: Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<MyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: DetailFragmentArgs by navArgs()

        val context = safeArgs.context
        val data = safeArgs.selectedItemData

        var testMessage = context;
        if ( data != null) {
            testMessage = "$context \n${data.context}"
        }

        binding.detailTextView.text = testMessage
    }

    fun load(selectedItemModel:ItemModel) {

    }
}