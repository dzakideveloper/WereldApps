package com.example.wereldapps.ui.indo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wereldapps.data.response.IndonesiaResponseItem
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.databinding.RowIndoBinding
import com.example.wereldapps.databinding.RowItemBinding
import com.example.wereldapps.ui.negara.NegaraAdapter
import com.example.wereldapps.utils.OnItemClickCallbackIndonesia
import com.example.wereldapps.utils.OnItemClickCallbackNegara

class IndonesiaAdapter(val listIndonesia: List<IndonesiaResponseItem>): RecyclerView.Adapter<IndonesiaAdapter.IndonesiaViewHolder>() {
    class IndonesiaViewHolder(val binding: RowIndoBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = IndonesiaViewHolder(
        RowIndoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    private var onItemClickCallback: OnItemClickCallbackIndonesia? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallbackIndonesia){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: IndonesiaViewHolder, position: Int) {
        val data = listIndonesia[position]
        holder.binding.apply {
            tvTitleIndo.text = data.title
            tvLokasiIndo.text = data.lokasi

            holder.itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(data)
            }
        }
    }

    override fun getItemCount(): Int = listIndonesia.size
}