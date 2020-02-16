package com.example.lastfmtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmtest.R
import com.example.lastfmtest.databinding.ItemArtistBinding
import com.example.lastfmtest.model.Artist
import com.example.lastfmtest.model.geoTopArtists
import com.squareup.picasso.Picasso

class ArtistsAdapter: RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {
    private var artists: ArrayList<Artist> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemArtistBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_artist, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artists[position])
        Picasso.get()
            .load(artists.get(position).image.get(0).text)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.imageArtist())

    }

    override fun getItemCount(): Int {
        return if(artists.isNotEmpty()) artists.size else 0
    }

    fun updatePostList(artists: ArrayList<Artist>){
        this.artists.addAll(artists)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemArtistBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ApiArtistViewModel()
        fun bind(artist:Artist){
            viewModel.bind(artist)
            binding.viewModel = viewModel
        }
        fun imageArtist(): ImageView {
            return binding.imageArtist
        }
    }
}