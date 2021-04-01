package ru.dast_6_tino.androidx_navigation_example.main.profile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.dast_6_tino.androidx_navigation_example.MainNavigationListener
import ru.dast_6_tino.androidx_navigation_example.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var callback: MainNavigationListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = requireActivity() as MainNavigationListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exitButton.setOnClickListener { callback.onLogout() }
    }

}
