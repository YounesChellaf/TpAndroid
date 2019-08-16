package com.example.stockage_local

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint :Endpoints by lazy {
        Retrofit.Builder().baseUrl("http://e097436m.ngrok.io").
            addConverterFactory(GsonConverterFactory.create()).
            build().create(Endpoints::class.java)
    }
}