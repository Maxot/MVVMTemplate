package com.maxot.mvvmtemplate.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maxot.mvvmtemplate.databinding.RvItemRepositoryBinding
import com.maxot.mvvmtemplate.data.model.others.Repository

class RepositoryRecyclerViewAdapter(private var items: ArrayList<Repository>,
                                    private var listener: OnItemClickListener)
    : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0?.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, p0, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    fun replaceData(it: ArrayList<Repository>) {
        items = it
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: RvItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }
    }
}