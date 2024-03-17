package com.example.retrofit_gpt

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BIble_service {

    interface ApiService {
        @GET("v1/bibles/{bibleId}/verses/{verseId}")
        suspend fun obterDados(
            @Query("api_key") apiKey: String
        ): Response<List<Bible_Model>>
    }
}