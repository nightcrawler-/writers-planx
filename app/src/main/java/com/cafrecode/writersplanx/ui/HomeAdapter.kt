package com.cafrecode.writersplanx.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafrecode.writersplanx.databinding.ListItemMessageBinding
import com.cafrecode.writersplanx.db.Message

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var messages: ArrayList<Message> = arrayListOf()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    inner class ViewHolder(internal var binding: ListItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Message) {
            binding.msg = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ListItemMessageBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messages.get(position))
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getItemCount(): Int = if (messages.isNotEmpty()) messages.size
    else 0

    companion object {
        private val TAG = HomeAdapter::class.java.simpleName
    }
}