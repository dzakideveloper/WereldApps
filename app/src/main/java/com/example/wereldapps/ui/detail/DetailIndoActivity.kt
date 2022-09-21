package com.example.wereldapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wereldapps.data.response.IndonesiaResponseItem
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.databinding.ActivityDetailIndoBinding
import com.example.wereldapps.databinding.ActivityDetailNegaraBinding

class DetailIndoActivity : AppCompatActivity() {

    private var _binding: ActivityDetailIndoBinding? = null
    private val binding get() = _binding as ActivityDetailIndoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailIndoBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<IndonesiaResponseItem>(EXTRA_DATA)

        title = data?.title

        binding.apply {
            tvDescDetailIndo.text = data?.deskripsi
            tvLokasiDetailIndo.text = data?.lokasi
            tvTitleDetailIndo.text = data?.title
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