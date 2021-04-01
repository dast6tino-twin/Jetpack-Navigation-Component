package ru.dast_6_tino.androidx_navigation_example.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_list.*
import ru.dast_6_tino.androidx_navigation_example.R
import ru.dast_6_tino.androidx_navigation_example.main.list.details.DetailsDialogFragment

class ListFragment : Fragment() {

    private lateinit var adapter: ListAdapter
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListAdapter()
        adapter.setData(DogFactory.defaultItems)
        adapter.setListener(::onItemSelected)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    private fun onItemSelected(item: Dog) {
        val bundle = DetailsDialogFragment.getBundle(item)
        navController.navigate(R.id.detailsDialogFragment, bundle)
    }

}
