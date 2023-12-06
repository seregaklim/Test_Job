package com.seregaklim.api

import com.seregaklim.data.AuthRequest
import com.seregaklim.data.Payment
import com.seregaklim.data.UserToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Streaming

private const val BASE_URL = "https://easypay.world/api-test/"

private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
}

private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()

interface ApiService {


    @Headers("app-key:12345", "v:1")
    @POST("login")
 suspend  fun auth(@Body authRequest:AuthRequest):Response<UserToken>



    @Streaming
    @Headers("app-key:12345", "v:1",)
    @GET("payments")
  suspend  fun getpaymentsAuth(@Header("token") token: String):Response<Payment>



}

object PostsApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}