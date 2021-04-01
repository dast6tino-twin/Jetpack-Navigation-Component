package ru.dast_6_tino.androidx_navigation_example.main.list.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dialog_fragment_details.*
import ru.dast_6_tino.androidx_navigation_example.R
import ru.dast_6_tino.androidx_navigation_example.main.list.Dog

class DetailsDialogFragment : DialogFragment() {

    companion object {

        private const val EXTRA_ITEM = "item"

        fun getBundle(item: Dog) = Bundle().apply { putParcelable(EXTRA_ITEM, item) }

    }

    private val navController by lazy { findNavController() }
    private val item by lazy {
        arguments?.getParcelable<Dog>(EXTRA_ITEM)
            ?: throw NullPointerException("Item must not be null")
    }

    override fun getTheme(): Int = R.style.FullScreenDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_fragment_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = item.name
        toolbar.setNavigationOnClickListener { navController.popBackStack() }
        toolbar.title = name

        nameTV.text = getString(R.string.details_fragment_name, name)
        breedTV.text = getString(R.string.details_fragment_breed, item.breed)
        descriptionTV.text = item.description
    }

}
