package com.example.wereldapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.data.response.TravelResponseItem
import com.example.wereldapps.databinding.ActivityDetailNegaraBinding

class DetailNegaraActivity : AppCompatActivity() {

    private var _binding: ActivityDetailNegaraBinding? = null
    private val binding get() = _binding as ActivityDetailNegaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailNegaraBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<NegaraResponseItem>(EXTRA_DATA)

        title = data?.title

        binding.apply {
            Glide.with(this@DetailNegaraActivity)
                .load(data?.image)
                .into(ivDetailCountry)
            tvTitleDetailCountry.text = data?.title
            tvDesc.text = data?.description
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