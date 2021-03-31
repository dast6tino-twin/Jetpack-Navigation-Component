package ru.dast_6_tino.androidx_navigation_example.main.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import ru.dast_6_tino.androidx_navigation_example.MainNavigationListener
import ru.dast_6_tino.androidx_navigation_example.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exitButton.setOnClickListener { (requireActivity() as? MainNavigationListener)?.onLogout() }
    }

}
