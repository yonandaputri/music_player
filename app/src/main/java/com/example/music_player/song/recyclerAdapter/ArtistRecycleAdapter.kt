package com.example.music_player.song.recyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.music_player.R
import com.example.music_player.room.artistWithSongs.artist.Artist
import com.squareup.picasso.Picasso

class ArtistRecycleAdapter(private val artistList: List<Artist>) :
    RecyclerView.Adapter<ArtistViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item_layout, parent, false)
        return ArtistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        println("$position ${artistList[position].name}")
        holder.artistName.text = artistList[position].name
        holder.albumName.text = artistList[position].title
        Picasso.get().load(artistList[position].photoUrl).into(holder.imageArtist)
        val bundle = bundleOf(
            Pair("artistId", artistList[position].artistId),
            Pair("title", artistList[position].title),
            Pair("photoUrl", artistList[position].photoUrl)
        )
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listSong_to_showMusic, bundle)
        }
    }

}

class ArtistViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val albumName = v.findViewById<TextView>(R.id.album_name)
    val artistName = v.findViewById<TextView>(R.id.artist_name)
    val imageArtist = v.findViewById<ImageView>(R.id.image_artist)
}