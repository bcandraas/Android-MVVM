package io.bintang.todo.data.remote

import io.bintang.todo.base.BaseRemoteDataSource
import javax.inject.Inject

class HomeRemoteDataSource @Inject constructor(private val api: ApiService) : BaseRemoteDataSource() {

    suspend fun nowPlaying() = getApiResult {  api.nowPlaying() }

}