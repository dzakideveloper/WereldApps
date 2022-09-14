package com.example.wereldapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wereldapps.R
import com.example.wereldapps.data.response.TravelResponseItem
import com.example.wereldapps.databinding.ActivityDetailTravelBinding

class DetailTravelActivity : AppCompatActivity() {

    private var _binding: ActivityDetailTravelBinding? = null
    private val binding get() = _binding as ActivityDetailTravelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailTravelBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<TravelResponseItem>(EXTRA_DATA)

        title = data?.title

        binding.apply {
            Glide.with(this@DetailTravelActivity)
                .load(data?.image)
                .into(ivDetailTraval)
            tvTitleDetailTravel.text = data?.title
            tvLoc.text = data?.lokasi
            tvRate.text = data?.rating
            tvDesc.text = data?.deskripsi
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}