package com.keeper.keeperrecord.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.keeper.keeperrecord.R
import com.keeper.keeperrecord.binding.BaseFragment
import com.keeper.keeperrecord.databinding.LoginFragmentBinding
import com.keeper.keeperrecord.util.hideKeyboard
import com.keeper.keeperrecord.util.isNotValidPasswordLength
import com.keeper.keeperrecord.util.matchesNotEmail
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseFragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@LoginFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        login_btn.setOnClickListener {
            val email = email.text
            val password = password.text
            hideKeyboard()
            if (isValid(email, password)) {
                showProgress(true)
                viewModel.login(email, password) {
                    showProgress(false)
                    showHome()
                }
            }
        }
    }

    private fun isValid(email: String, passWord: String): Boolean {
        if (email.matchesNotEmail()) {
            showError(getString(R.string.email_not_valid))
            return false
        }
        if (passWord.isNotValidPasswordLength()) {
            showError(getString(R.string.password_not_valid))
            return false
        }
        return true
    }

    private fun showError(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
    }

    private fun showHome() {
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun showProgress(show: Boolean) {
        binding.showProgress = show
    }
}