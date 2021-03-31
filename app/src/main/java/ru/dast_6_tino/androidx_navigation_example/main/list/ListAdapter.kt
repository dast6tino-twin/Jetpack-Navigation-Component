package ru.dast_6_tino.androidx_navigation_example.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.dast_6_tino.androidx_navigation_example.R

class ListAdapter(
    private val onClickListener: (Dog) -> Unit
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var data: List<Dog> = emptyList()

    fun setData(items: List<Dog> = Dog.defaultItems) {
        data = items
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        .let(ListAdapter::ViewHolder)

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) = holder.onBind(data[position], onClickListener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(item: Dog, onClickListener: (Dog) -> Unit) = with(itemView) {
            findViewById<TextView>(R.id.nameTV).text = item.breed
            findViewById<TextView>(R.id.descriptionTV).text = item.description
            setOnClickListener { onClickListener.invoke(item) }
        }

    }

}
