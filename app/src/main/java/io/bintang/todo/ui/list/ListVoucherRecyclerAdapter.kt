package io.bintang.todo.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.bintang.todo.data.remote.response.Voucher
import io.bintang.todo.databinding.ItemListVoucherBinding

class ListVoucherRecyclerAdapter(private val listener: VoucherClickListener) : ListAdapter<Voucher, ListVoucherRecyclerAdapter.ListVoucherViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVoucherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListVoucherBinding.inflate(layoutInflater, parent,false)
        return ListVoucherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListVoucherViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    inner class ListVoucherViewHolder(val binding: ItemListVoucherBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(voucher: Voucher, listener: VoucherClickListener) {
            binding.voucher = voucher
            binding.root.setOnClickListener { listener.onVoucherPressed(voucher.voucherId) }
            binding.btnUse.setOnClickListener { listener.onButtonUsePressed(voucher.name) }
            binding.executePendingBindings()
        }
    }

    interface VoucherClickListener {
        fun onVoucherPressed(id:Int)
        fun onButtonUsePressed(name: String)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Voucher>() {
            override fun areItemsTheSame(oldItem: Voucher, newItem: Voucher): Boolean {
                return oldItem.voucherId == newItem.voucherId
            }

            override fun areContentsTheSame(oldItem: Voucher, newItem: Voucher): Boolean {
                return oldItem == newItem
            }

        }
    }
}