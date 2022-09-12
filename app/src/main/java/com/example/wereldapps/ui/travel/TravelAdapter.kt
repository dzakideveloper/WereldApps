package com.example.wereldapps.ui.travel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wereldapps.data.response.TravelResponseItem
import com.example.wereldapps.databinding.RowItemBinding
import com.example.wereldapps.utils.OnItemClickCallbackTravel

class TravelAdapter(val listTravel: List<TravelResponseItem>): RecyclerView.Adapter<TravelAdapter.TravelViewHolder>() {
    class TravelViewHolder(val binding: RowItemBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TravelViewHolder (
        RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    private var onItemClickCallback: OnItemClickCallbackTravel? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallbackTravel){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        val data = listTravel[position]
        holder.binding.apply {
            tvRow.text = data.title
            Glide.with(imgRow)
                .load(data.image)
                .into(imgRow)

            holder.itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(data)
            }
        }
    }

    override fun getItemCount(): Int = listTravel.size
}