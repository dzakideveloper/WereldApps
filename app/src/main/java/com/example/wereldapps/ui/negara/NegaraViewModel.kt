package com.example.wereldapps.ui.negara

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wereldapps.data.network.ApiClient
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.data.response.TravelResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NegaraViewModel: ViewModel() {
    val listNegara = MutableLiveData<List<NegaraResponseItem>>()

    fun getListNegara() {
        ApiClient.getApiService().getNegara()
            .enqueue(object : Callback<List<NegaraResponseItem>> {
                override fun onResponse(call: Call<List<NegaraResponseItem>>, response: Response<List<NegaraResponseItem>>) {
                    listNegara.postValue(response.body())
                }
                override fun onFailure(call: Call<List<NegaraResponseItem>>, t: Throwable) {
                    Log.e("error", "OnFailure: $t")
                }
            })
    }

    fun getResultNegara(): LiveData<List<NegaraResponseItem>> = listNegara
}