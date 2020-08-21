package com.example.music_player.room.artistWithSongs.song

import androidx.room.*


@Entity
class Song(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var songId: Int=0,
    @ColumnInfo(name = "idArtistSong") var idArtistSong: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "durationSong") var durationSong: String
){}