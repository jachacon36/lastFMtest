package com.example.lastfmtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmtest.R
import com.example.lastfmtest.databinding.ItemArtistBinding
import com.example.lastfmtest.model.Artist
import com.example.lastfmtest.model.geoTopArtists

class ArtistsAdapter: RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    private lateinit var artists: geoTopArtists

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemArtistBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_artist, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artists.topartists.artist[position])
    }

    override fun getItemCount(): Int {
        return if(::artists.isInitialized) artists.topartists.artist.size else 0
    }

    fun updatePostList(artists: geoTopArtists){
        this.artists = artists
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemArtistBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ApiArtistViewModel()

        fun bind(artist:Artist){
            viewModel.bind(artist)
            binding.viewModel = viewModel
        }
    }
}