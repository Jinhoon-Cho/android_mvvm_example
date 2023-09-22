package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentListBinding
import viewBinding

class ListFragment: Fragment(R.layout.fragment_list) {
    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel by viewModels<MyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val data = ItemModel();
            data.context = "this is test data."
            moveDetailPage(data)
        }
    }

    private fun moveDetailPage(data:ItemModel) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(
            context = "This is moving test!!!",
            selectedItemData = data
        ))
    }

    fun loadData() {

    }

    fun applyListView() {
        binding.listRecyclerView.adapter
    }
}

class ListViewAdapter {

}