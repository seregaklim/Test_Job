package com.seregaklim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seregaklim.data.ResponseX
import com.seregaklim.testjob.databinding.ListResponseBinding


interface ResponseInteractionListener {

}

class ResponseAdapter(
    private val responseInteractionListener: ResponseInteractionListener,
) : ListAdapter<ResponseX, ResponseViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val binding = ListResponseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResponseViewHolder(binding,responseInteractionListener)
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class ResponseViewHolder(
    private val binding: ListResponseBinding,
    private val responseInteractionListener: ResponseInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(responseX: ResponseX) {
        binding.apply {
            tvTextAmount.text = responseX.amount
            tvTextCreated.text = responseX.created.toString()
            tvTitlePayment.text = responseX.title
        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<ResponseX>() {
    override fun areItemsTheSame(oldItem: ResponseX, newItem: ResponseX): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResponseX, newItem: ResponseX): Boolean {
        return oldItem == newItem
    }
}
