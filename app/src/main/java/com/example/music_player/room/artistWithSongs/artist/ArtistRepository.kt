package com.example.music_player.room.artistWithSongs.artist

import androidx.lifecycle.LiveData

class ArtistRepository(private val artistDao: ArtistDao) {
    val allArtist = artistDao.getAllArtist()
    fun createArtist(artist: Artist) {
        artistDao.createNewArtist(artist)
    }
}