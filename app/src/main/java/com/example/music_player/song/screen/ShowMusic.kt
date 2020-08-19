package com.example.music_player.song.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.example.music_player.R
import com.example.music_player.song.viewModel.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_show_music.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShowMusic.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowMusic : Fragment() {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listSong = songViewModel.songLiveData.value
        val position = arguments?.getInt("position")

        show_title_song.text = position?.let { listSong?.get(it)?.title }
        Picasso.get().load(position?.let { listSong?.get(it)?.urlArtistPhoto }).into(image_artist_show)
    }
}
