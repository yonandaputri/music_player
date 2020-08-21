package com.example.music_player.room.artistWithSongs.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.music_player.room.artistWithSongs.ArtistWithSongs

@Dao
interface SongDao {
    @Query(value = "SELECT * FROM Artist WHERE artistId= :idArtistSong")
    fun getArtistWithSongs(idArtistSong: Int): LiveData<ArtistWithSongs>

    @Insert
    fun createNewSong(song: Song)
}