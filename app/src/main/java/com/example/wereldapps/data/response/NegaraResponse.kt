package com.example.wereldapps.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NegaraResponse(

	@field:SerializedName("NegaraResponse")
	val negaraResponse: List<NegaraResponseItem?>? = null
) : Parcelable

@Parcelize
data class NegaraResponseItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable
