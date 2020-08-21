package com.example.music_player.room.artistWithSongs.artist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArtistDao {
    @Insert
    fun createNewArtist(artist: Artist)

    @Query(value = "SELECT * FROM Artist")
    fun getAllArtist(): LiveData<List<Artist>>

    @Query(value = "SELECT * FROM Artist WHERE artistId = :artistId")
    fun getArtistWithId(artistId: Int): Artist
}