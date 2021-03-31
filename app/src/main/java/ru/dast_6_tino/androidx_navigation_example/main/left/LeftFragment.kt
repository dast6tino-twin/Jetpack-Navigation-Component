package ru.dast_6_tino.androidx_navigation_example.main.left

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_left.*
import ru.dast_6_tino.androidx_navigation_example.R

class LeftFragment : Fragment(R.layout.fragment_left) {

    companion object {
        private const val COUNT = "COUNT"
        private const val DEFAULT_COUNT_VALUE = 0
    }

    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val count = arguments?.getInt(COUNT, DEFAULT_COUNT_VALUE) ?: DEFAULT_COUNT_VALUE
        backButton.isVisible = count > 0
        backButton.setOnClickListener { navController.popBackStack() }

        var description = ""
        (0..count).forEach { _ -> description += getString(R.string.fragment_left) + " " }
        descriptionTV.text = description
        deeperButton.setOnClickListener {
            val bundle = Bundle().apply { putInt(COUNT, count + 1) }
            navController.navigate(R.id.action_leftFragment_to_leftFragment, bundle)
        }
    }

}
