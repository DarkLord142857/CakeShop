package com.example.cakeshop.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val apiService : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://3048-2402-800-637c-2519-f419-7082-b7d4-c3cb.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}