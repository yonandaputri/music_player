package com.example.music_player.song.recyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music_player.R
import com.example.music_player.room.artistWithSongs.ArtistWithSongs

class SongRecycleAdapter(private val songList: ArtistWithSongs) : RecyclerView.Adapter<SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.artist_song_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.songs.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        println("$position ${songList.songs[position].title}")
        holder.songTitle.text = songList.songs[position].title
        holder.songDuration.text = songList.songs[position].durationSong
        var playMusic = true
        holder.playMusicButton.setBackgroundResource(R.drawable.ic_play_arrow_24dp)
        holder.playMusicButton.setOnClickListener{
            if (playMusic) {
                holder.playMusicButton.setBackgroundResource(R.drawable.ic_pause_24dp)
                playMusic = false
            } else {
                holder.playMusicButton.setBackgroundResource(R.drawable.ic_play_arrow_24dp)
                playMusic = true
            }
        }
    }
}

class SongViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val songTitle = v.findViewById<TextView>(R.id.title_song)
    val songDuration = v.findViewById<TextView>(R.id.song_duration)
    val playMusicButton = v.findViewById<ImageButton>(R.id.play_song_button)
}
