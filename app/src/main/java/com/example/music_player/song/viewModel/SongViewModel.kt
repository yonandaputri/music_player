package com.example.music_player.song.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.music_player.room.AppRoomDatabase
import com.example.music_player.room.artistWithSongs.song.Song
import com.example.music_player.room.artistWithSongs.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SongRepository

    init {
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        repository = SongRepository(songDao)
    }

    fun getArtistWithSongs(id: Int) = repository.allSongs(id)

    fun createNewSong(song: Song) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createSongs(song)
        }
    }
}