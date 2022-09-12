package com.example.wereldapps.data.network

import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.data.response.TravelResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("Travel")
    fun getTravel(): Call<List<TravelResponseItem>>

    @GET("Negara")
    fun getNegara(): Call<List<NegaraResponseItem>>
}