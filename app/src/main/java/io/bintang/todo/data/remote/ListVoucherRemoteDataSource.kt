package io.bintang.todo.data.remote

import io.bintang.todo.base.BaseRemoteDataSource
import javax.inject.Inject

class ListVoucherRemoteDataSource @Inject constructor(private val api: ApiService) : BaseRemoteDataSource() {

    suspend fun listVoucher() = getApiResult {  api.listVoucher() }

}