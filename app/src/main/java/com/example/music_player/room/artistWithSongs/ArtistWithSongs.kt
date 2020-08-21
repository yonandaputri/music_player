package com.example.music_player.room.artistWithSongs

import androidx.room.Embedded
import androidx.room.Relation
import com.example.music_player.room.artistWithSongs.artist.Artist
import com.example.music_player.room.artistWithSongs.song.Song

class ArtistWithSongs(
    @Embedded val artist: Artist,
    @Relation(
        parentColumn = "artistId",
        entityColumn = "idArtistSong"
    )
    val songs: List<Song>
){}