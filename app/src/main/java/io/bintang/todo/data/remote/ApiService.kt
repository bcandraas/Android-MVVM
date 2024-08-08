package io.bintang.todo.data.remote

import io.bintang.todo.data.remote.response.ListVoucherResponse
import io.bintang.todo.data.remote.response.NowPlayingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {

    @GET("now_playing")
    suspend fun nowPlaying(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Response<NowPlayingResponse>


    @Headers("Content-Type: application/json")
    @GET("v1/voucher")
    suspend fun listVoucher(
        @Query("page") page: Int = 1,
        @Query("size") size : Int = 10
    ): Response<ListVoucherResponse>
}