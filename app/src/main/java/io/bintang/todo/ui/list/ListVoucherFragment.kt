package io.bintang.todo.ui.home.list


import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import io.bintang.todo.R
import io.bintang.todo.base.BaseFragment
import io.bintang.todo.data.remote.response.ListVoucherResponse
import io.bintang.todo.data.remote.response.Voucher
import io.bintang.todo.databinding.FragmentListVoucherBinding
import io.bintang.todo.ui.list.ListVoucherViewModel
import io.bintang.todo.ui.list.ListVoucherRecyclerAdapter
import io.bintang.todo.vo.Result
import kotlinx.android.synthetic.main.fragment_list_voucher.*
import kotlinx.android.synthetic.main.fragment_list_voucher.view.*
import kotlinx.android.synthetic.main.item_list_voucher.*
import timber.log.Timber

class ListVoucherFragment : BaseFragment<FragmentListVoucherBinding, ListVoucherViewModel>(), ListVoucherRecyclerAdapter.VoucherClickListener{

    override fun getLayoutResourceId() = R.layout.fragment_list_voucher
    override fun getViewModelClass() = ListVoucherViewModel::class.java
    private lateinit var adapterList : ListVoucherRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        vm.getAllListVoucher()

        vm.listVoucher.observe(this, Observer { subscribeListVoucher(it) })

    }

    private fun initRecyclerView() {
        adapterList = ListVoucherRecyclerAdapter(this)
        val layoutManager = LinearLayoutManager(this.activity)
        binding.rvListVoucher.layoutManager = layoutManager
        binding.rvListVoucher.setHasFixedSize(true)
        binding.rvListVoucher.adapter = adapterList
    }

    private fun subscribeListVoucher(it: Result<ListVoucherResponse>) {
        tvNoVoucher.visibility = View.GONE
        rvListVoucher.visibility = View.VISIBLE
        when(it.status) {
            Result.Status.LOADING -> {
                Timber.v("Status : Loading")
                haveNoListVoucher("Loading . . .")
                ivTotalVoucher.isVisible = false
                tvTotalVoucher.isVisible = false
            }
            Result.Status.SUCCESS -> {
                isSuccess(it)
            }
            Result.Status.ERROR -> {
                isError(it)
            }
        }
    }


    override fun onVoucherPressed(id:Int) {
        //pindah ke detail voucher frag
    }

    override fun onButtonUsePressed(name : String) {
        longSnackbar("Voucher $name terpakai")
    }

    fun haveNoListVoucher(message: String) {
        rvListVoucher.visibility = View.GONE
        tvNoVoucher.text = message
        tvNoVoucher.visibility = View.VISIBLE
    }

    fun totalVoucher(total:Int){
        ivTotalVoucher.isVisible = true
        tvTotalVoucher.isVisible = true
        tvTotalVoucher.text = "Jumlah voucher yang anda miliki adalah $total"
    }


    private fun refreshData(vouchers: List<Voucher>) {
        adapterList.submitList(vouchers)
    }

    fun isError(it:Result<ListVoucherResponse>){
        Timber.v("Status : Error" )
        it.data?.data?.size?.let { it1 -> totalVoucher(it1) }
        if (it.httpCode == 500){
            haveNoListVoucher("Anda tidak terhubung dengan internet")
        } else {
            haveNoListVoucher(it.message.toString())
        }
    }

    fun isSuccess(it:Result<ListVoucherResponse>){
        Timber.v("Status : Success" )
        it.data?.data?.size?.let { it1 -> totalVoucher(it1) }
        if (it.data == null && it.httpCode == 200){
            haveNoListVoucher("Anda tidak memiliki voucher")
        } else {
            it.data?.data?.let {it1 -> refreshData(it1)}
        }
    }
}
