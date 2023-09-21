package com.example.horoscope.horoscope_list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.databinding.ItemHoroscopeBinding

class HoroscopeSignsAdapter(private val horoscopeSignsImageList: List<Int>) :
    RecyclerView.Adapter<HoroscopeSignsAdapter.HoroscopeItemViewHolder>() {

    private lateinit var clickListener: OnItemClickListener
    private lateinit var binding: ItemHoroscopeBinding

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeItemViewHolder {
        binding = ItemHoroscopeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoroscopeItemViewHolder(clickListener, binding)
    }

    override fun onBindViewHolder(holder: HoroscopeItemViewHolder, position: Int) {
        val horoscopeImage = horoscopeSignsImageList[position]
        holder.bind(horoscopeImage)
    }

    override fun getItemCount(): Int = horoscopeSignsImageList.size

    inner class HoroscopeItemViewHolder(
        listener: OnItemClickListener,
        private var binding: ItemHoroscopeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(horoscopeItem: Int) {
            binding.horoscopeIv.setImageResource(horoscopeItem)
        }
    }
}