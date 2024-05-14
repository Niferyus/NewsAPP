package com.anilderinbay.Newsapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anilderinbay.Newsapp.model.response.NewsResponse

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    var savedList: ArrayList<NewsResponse.Article> = arrayListOf()
    var favoritesItemClickListener: (NewsResponse.Article) -> Unit = {}

    inner class FavoritesViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: NewsResponse.Article) {
            itemView.setOnClickListener {
                favoritesItemClickListener(item)
            }
        }
        


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}