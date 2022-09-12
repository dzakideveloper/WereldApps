package com.example.wereldapps.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TravelResponse(

	@field:SerializedName("TravelResponse")
	val travelResponse: List<TravelResponseItem?>? = null
) : Parcelable

@Parcelize
data class TravelResponseItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("Lokasi")
	val lokasi: String? = null,

	@field:SerializedName("Rating")
	val rating: String? = null,

	@field:SerializedName("Title")
	val title: String? = null,

	@field:SerializedName("Deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
