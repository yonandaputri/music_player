package com.example.music_player.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.music_player.room.artistWithSongs.artist.Artist
import com.example.music_player.room.artistWithSongs.artist.ArtistDao
import com.example.music_player.room.artistWithSongs.song.Song
import com.example.music_player.room.artistWithSongs.song.SongDao

@Database(entities = arrayOf(Artist::class, Song::class), version = 2, exportSchema = false)
public abstract class AppRoomDatabase : RoomDatabase() {

    companion object {
        private var DATABASE_INSTANCE: AppRoomDatabase? = null
        fun getDatabaseInstance(context: Context): AppRoomDatabase {
            if (DATABASE_INSTANCE != null) {
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "music_player_database"
            ).fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }

    abstract fun artistDao(): ArtistDao
    abstract fun songDao(): SongDao
}