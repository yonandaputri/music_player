package com.example.music_player.song.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_player.song.model.SongModel
import java.text.FieldPosition

class SongViewModel : ViewModel() {
    val songList: MutableList<SongModel> = mutableListOf<SongModel>(
        SongModel("HOLO","Lee Hi","https://www.wowkeren.com/display/images/photo/2020/07/17/00320774.jpg"),
        SongModel("God's Menu", "Stray Kids", "https://www.dreamers.id/img_artikel/6stray-kids-gods-menu.jpg"),
        SongModel("Left & Right", "Seventeen", "https://www.hellokpop.com/wp-content/uploads/2020/06/seventeen-henggarae-officila-photo-660x400.jpg"),
        SongModel("Zombie", "DAY6", "https://img.okezone.com/content/2020/05/11/205/2212471/day6-hadirkan-realita-hidup-di-mv-comeback-zombie-GOkT6sKoTq.jpg"),
        SongModel("180 Degree", "Ben", "https://i1.wp.com/www.koreanesia.com/wp-content/uploads/2018/12/1-14.jpg?fit=900%2C600&ssl=1"),
        SongModel("Wannabe", "Itzy", "https://cdn.idntimes.com/content-images/community/2020/03/img-20200320-192248-feff0a4955c8f2ca1f616b4f56df7315_600x400.jpg")
    )

    val songLiveData: MutableLiveData<MutableList<SongModel>> = MutableLiveData(songList)

    fun addSong(song: SongModel) {
        songList.add(song)
        songLiveData.value = songList
    }
}