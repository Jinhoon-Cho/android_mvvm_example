package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentSecondPageBinding
import viewBinding

class SecondPageFragment: Fragment(R.layout.fragment_second_page) {

    private val binding by viewBinding(FragmentSecondPageBinding::bind)
    private val viewModel by viewModels<MyPageViewModel>()

    private lateinit var testString: String
    private val testStringCount: Int by lazy {
        testString.length
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testString = "testString"
        println("testStringCount: $testStringCount")

        val safeArgs: SecondPageFragmentArgs by navArgs()
        viewModel.message = safeArgs.secondPageMessage

        val testObserver = Observer<String> {
            binding.textView.text = it
        }

        viewModel.currentName.observe(viewLifecycleOwner, testObserver)

        binding.vm = viewModel
        binding.button.setOnClickListener {
//            viewModel.message = "button clicked"
            viewModel.currentName.value = "button clicked!!"
        }
    }
}