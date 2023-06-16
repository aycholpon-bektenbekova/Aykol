package com.example.aykol.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aykol.R
import com.example.aykol.databinding.NewsItemBinding

class NewsAdapter(
    val context: Fragment,
    private val onClick: (Model) -> Unit
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var items = arrayListOf<Model>()

    fun addItems(model: Model){
        items.add(model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class NewsViewHolder(private val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Model) {
            itemView.setOnClickListener {
                onClick.invoke(model)
            }
            binding.itemTv.text = model.title
            Glide.with(context).load(R.drawable.news).into(binding.img)
        }
    }
}