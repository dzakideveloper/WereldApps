package com.example.wereldapps.ui.indo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wereldapps.data.network.ApiClient
import com.example.wereldapps.data.response.IndonesiaResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IndonesiaViewModel: ViewModel() {
    val listIndonesia = MutableLiveData<List<IndonesiaResponseItem>>()

    fun getListIndonesia() {
        ApiClient.getApiService().getIndonesia()
            .enqueue(object : Callback<List<IndonesiaResponseItem>> {
                override fun onResponse(
                    call: Call<List<IndonesiaResponseItem>>,
                    response: Response<List<IndonesiaResponseItem>>
                ) {
                    listIndonesia.postValue(response.body())
                }
                override fun onFailure(call: Call<List<IndonesiaResponseItem>>, t: Throwable) {
                    Log.e("error", "OnFailure: $t")
                }
            })
    }

    fun getResultIndonesia(): LiveData<List<IndonesiaResponseItem>> = listIndonesia
}