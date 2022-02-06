package com.shenawynkov.onepagetest.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.shenawynkov.domain.model.contact.ContactX

import com.shenawynkov.onepagetest.R
import com.shenawynkov.onepagetest.databinding.ItemContactBinding

class ContactsAdapter(
    private var list: List<ContactX>,
    private val contactsListener: ContactsListener
) : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(obj: Any) {

            binding.setVariable(BR.obj, obj)
            binding.executePendingBindings()

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemContactBinding>(
            layoutInflater, R.layout.item_contact, parent, false
        )
        return MyViewHolder(binding)
    }


    override fun getItemCount() = list.size


    fun setNewList(newList: List<ContactX>) {
        this.list = newList
        notifyDataSetChanged()
    }

    interface ContactsListener {
        fun onSectionSelected(cantact: ContactX)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj)
        holder.binding.root.setOnClickListener {
            contactsListener.onSectionSelected(list[holder.adapterPosition])
        }
        holder.binding.btSeeMore.setOnClickListener {
            list[holder.adapterPosition].alterVisabilty()
            notifyItemChanged(holder.adapterPosition)

        }
    }

    private fun getObjForPosition(position: Int): Any {
        return list.get(position)
    }


}
