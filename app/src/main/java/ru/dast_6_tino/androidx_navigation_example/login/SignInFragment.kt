package ru.dast_6_tino.androidx_navigation_example.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_sign_in.*
import ru.dast_6_tino.androidx_navigation_example.MainNavigationListener
import ru.dast_6_tino.androidx_navigation_example.R

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val navController by lazy { findNavController() }
    private lateinit var callback: MainNavigationListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = requireActivity() as MainNavigationListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener {
            navController.popBackStack(R.id.loginFlowFragment, false)
        }
        signInButton.setOnClickListener { callback.onLoginComplete() }
    }

}
