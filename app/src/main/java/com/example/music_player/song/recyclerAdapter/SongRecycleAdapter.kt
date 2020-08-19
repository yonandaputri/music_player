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
import com.example.music_player.song.model.SongModel
import com.squareup.picasso.Picasso

class SongRecycleAdapter(private val songList: List<SongModel>) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.music_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        println("$position ${songList[position].title}")
        holder.songTitle.text = songList[position].title
        holder.artistName.text = songList[position].artist
        Picasso.get().load(songList[position].urlArtistPhoto).into(holder.imageArtist)

        val bundle = bundleOf(Pair("position", position))
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listSong_to_showMusic, bundle)
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val songTitle = v.findViewById<TextView>(R.id.title_song)
    val artistName = v.findViewById<TextView>(R.id.artist_name)
    val imageArtist = v.findViewById<ImageView>(R.id.image_artist)
}
