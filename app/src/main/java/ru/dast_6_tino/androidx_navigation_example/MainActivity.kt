package ru.dast_6_tino.androidx_navigation_example

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

interface MainNavigationListener {
    fun onLoginComplete()
    fun onLogout()
}

class MainActivity : AppCompatActivity(R.layout.activity_main), MainNavigationListener {

    private val navigationController: NavController by lazy { findNavController(R.id.main_navigation_host_activity) }

    override fun onLoginComplete() = with(navigationController) {
        popBackStack(R.id.navigation_graph_login, true)
        navigate(R.id.action_global_navigation_graph_main)
    }

    override fun onLogout() = with(navigationController) {
        popBackStack(R.id.navigation_graph_main, true)
        navigate(R.id.action_global_navigation_graph_login)
    }

}
