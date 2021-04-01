package ru.dast_6_tino.androidx_navigation_example.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import ru.dast_6_tino.androidx_navigation_example.R

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var data: List<Dog> = emptyList()
    private var onClickListener: ((Dog) -> Unit)? = null

    fun setData(items: List<Dog>) {
        data = items
        notifyDataSetChanged()
    }

    fun setListener(onClickListener: ((Dog) -> Unit)?) {
        this.onClickListener = onClickListener
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

        fun onBind(item: Dog, onClickListener: ((Dog) -> Unit)?) = with(itemView) {
            nameTV.text = item.breed
            descriptionTV.text = item.description
            setOnClickListener { onClickListener?.invoke(item) }
        }

    }

}
