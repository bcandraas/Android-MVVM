package io.bintang.todo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.bintang.todo.data.remote.response.ListVoucherResponse
import io.bintang.todo.data.repository.ListVoucherRepository
import io.bintang.todo.util.CoroutinesDispatcherProvider
import io.bintang.todo.vo.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListVoucherViewModel @Inject constructor(
    private val repository: ListVoucherRepository,
    private val dispatcher: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _listVoucher = MutableLiveData<Result<ListVoucherResponse>>()
    val listVoucher: LiveData<Result<ListVoucherResponse>>
        get() = _listVoucher

    fun getAllListVoucher() {
        _listVoucher.postValue(Result.loading(null))
        viewModelScope.launch(dispatcher.io) {
            _listVoucher.postValue(repository.getAllListVoucher())
        }
    }
}