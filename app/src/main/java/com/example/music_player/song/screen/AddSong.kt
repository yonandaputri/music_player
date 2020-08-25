package com.example.music_player.song.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation

import com.example.music_player.R
import com.example.music_player.song.model.SongModel
import com.example.music_player.song.viewModel.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddSong.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSong : Fragment(), View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_song_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            save_song_button -> {
                val titleSong = input_title_song.text.toString()
                val artistName = input_artist_name.text.toString()
                val urlArtistPhoto = input_image_artist.text.toString()
                if (titleSong == "" || artistName == "" || urlArtistPhoto == "") {
                    Toast.makeText(
                        view?.context,
                        "Input Data Song Cann't Be Empty",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    songViewModel.addSong(SongModel(titleSong, artistName, urlArtistPhoto))
                    Toast.makeText(
                        view?.context,
                        "Success Add New Song!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
