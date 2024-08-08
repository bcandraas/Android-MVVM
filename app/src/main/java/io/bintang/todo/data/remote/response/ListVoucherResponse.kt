package io.bintang.todo.data.remote.response

data class ListVoucherResponse(
    val code: Int,
    val `data`: List<Voucher>,
    val message: String,
    val success: Boolean
)

data class Voucher(
    val active: Boolean,
    val date: String,
    val description: String,
    val image: String,
    val issuer: String,
    val name: String,
    val promoCode: String,
    val snk: String,
    val voucherId: Int
)