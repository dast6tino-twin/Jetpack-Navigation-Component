package ru.dast_6_tino.androidx_navigation_example.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.fragment_main.*
import ru.dast_6_tino.androidx_navigation_example.R
import ru.dast_6_tino.androidx_navigation_example.extensions.setupWithNavController

class MainFragment : Fragment(R.layout.fragment_main) {

    private var navController: NavController? = null

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.navigation_left,
            R.navigation.navigation_list,
            R.navigation.navigation_profile
        )

        navController = bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.fragment_main__nav_host_container,
            intent = requireActivity().intent
        )
    }

}
