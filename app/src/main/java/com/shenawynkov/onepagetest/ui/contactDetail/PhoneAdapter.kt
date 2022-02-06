package com.shenawynkov.onepagetest.ui.contactDetail

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
import com.shenawynkov.domain.model.contact.Phone

import com.shenawynkov.onepagetest.R
import com.shenawynkov.onepagetest.databinding.ItemContactBinding
import com.shenawynkov.onepagetest.databinding.ItemPhoneBinding
import com.shenawynkov.onepagetest.ui.contacts.ContactsAdapter

class PhoneAdapter(
    private var list: List<Phone>
) : RecyclerView.Adapter<PhoneAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: ItemPhoneBinding) : RecyclerView.ViewHolder(binding.root) {

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
        val binding = DataBindingUtil.inflate<ItemPhoneBinding>(
            layoutInflater, R.layout.item_phone, parent, false
        )
        return MyViewHolder(binding)
    }


    override fun getItemCount() = list.size


    fun setNewList(newList: List<Phone>) {
        this.list = newList
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj)

    }

    private fun getObjForPosition(position: Int): Any {
        return list.get(position)
    }


}
