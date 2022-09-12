package com.example.wereldapps.ui.negara

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wereldapps.data.response.NegaraResponseItem
import com.example.wereldapps.databinding.RowItemBinding
import com.example.wereldapps.utils.OnItemClickCallbackNegara

class NegaraAdapter(val listNegara: List<NegaraResponseItem>): RecyclerView.Adapter<NegaraAdapter.NegaraViewHolder>()  {
    class NegaraViewHolder(val binding: RowItemBinding):
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NegaraViewHolder (
        RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    private var onItemClickCallback: OnItemClickCallbackNegara? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallbackNegara){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: NegaraViewHolder, position: Int) {
        val data = listNegara[position]
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

    override fun getItemCount(): Int = listNegara.size
}