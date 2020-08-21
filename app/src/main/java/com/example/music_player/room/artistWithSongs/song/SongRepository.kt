package com.example.music_player.room.artistWithSongs.song

class SongRepository(private val songDao: SongDao) {
    fun allSongs(idArtistSong: Int) = songDao.getArtistWithSongs(idArtistSong)

    fun createSongs(song: Song) {
        songDao.createNewSong(song)
    }
}