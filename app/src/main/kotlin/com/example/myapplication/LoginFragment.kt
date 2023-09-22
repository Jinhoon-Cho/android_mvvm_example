package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import viewBinding

class LoginFragment: Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel by viewModels<MyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.isEnabled = !viewModel.isLogin();

        if (viewModel.isLogin()) {
            moveNextPage()
            return
        }

        binding.loginButton.setOnClickListener {
            viewModel.login(object : IFinishedListener<Boolean> {
                override fun finished(result: Boolean) {
                    if (result) {
                        login()
//                        moveNextPage()
                    }
                }
            })
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        val googleClient = GoogleSignIn.getClient(this.requireActivity(), gso)
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this.requireContext())
        if(account!=null) {
            println("displayName: ${account.displayName}")
            println("id: ${account.id}")
            println("email: ${account.email}")
        } else {
            println("account info is null.")
        }

    }

    private fun moveNextPage() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListFragment())
    }

    private fun login() {

    }
}