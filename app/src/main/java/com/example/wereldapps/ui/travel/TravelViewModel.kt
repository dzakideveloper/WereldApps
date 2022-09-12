package com.example.wereldapps.ui.travel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wereldapps.data.network.ApiClient
import com.example.wereldapps.data.response.TravelResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TravelViewHolder: ViewModel() {
    val listTravel = MutableLiveData<List<TravelResponseItem>>()

    fun getListTravel() {
        ApiClient.getApiService().getTravel()
            .enqueue(object : Callback<List<TravelResponseItem>> {
                override fun onResponse(call: Call<List<TravelResponseItem>>, response: Response<List<TravelResponseItem>>) {
                    listTravel.postValue(response.body())
                }
                override fun onFailure(call: Call<List<TravelResponseItem>>, t: Throwable) {
                    Log.e("error", "OnFailure: $t")
                }
            })
    }

    fun getResultTravel(): LiveData<List<TravelResponseItem>> = listTravel
}