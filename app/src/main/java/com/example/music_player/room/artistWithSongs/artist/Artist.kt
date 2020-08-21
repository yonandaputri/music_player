package com.example.music_player.room.artistWithSongs.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Artist(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var artistId: Int=0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "photoUrl") var photoUrl: String
){}
