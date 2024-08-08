package io.bintang.todo.data.repository

import io.bintang.todo.data.remote.ListVoucherRemoteDataSource
import javax.inject.Inject

class ListVoucherRepository @Inject constructor(private val remoteDataSource: ListVoucherRemoteDataSource) {
    suspend fun getAllListVoucher() = remoteDataSource.listVoucher()

}
