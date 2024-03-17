package com.example.retrofit_gpt

import com.example.retrofit_gpt.constantes.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitConfig {


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: BIble_service.ApiService by lazy {
        retrofit.create(BIble_service.ApiService::class.java)
    }
}