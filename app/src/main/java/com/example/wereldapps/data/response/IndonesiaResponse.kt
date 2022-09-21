package com.example.wereldapps.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndonesiaResponse(

	@field:SerializedName("IndonesiaResponse")
	val indonesiaResponse: List<IndonesiaResponseItem?>? = null
) : Parcelable

@Parcelize
data class IndonesiaResponseItem(

	@field:SerializedName("Lokasi")
	val lokasi: String? = null,

	@field:SerializedName("Rating")
	val rating: String? = null,

	@field:SerializedName("Title")
	val title: String? = null,

	@field:SerializedName("Deskripsi")
	val deskripsi: String? = null
) : Parcelable
