package com.example.music_player.song.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels

import com.example.music_player.R
import com.example.music_player.room.artistWithSongs.artist.Artist
import com.example.music_player.song.viewModel.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_add_artist.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddArtist.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddArtist : Fragment(), View.OnClickListener {

    val artistViewModel by activityViewModels<ArtistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_artist_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            save_artist_button -> {
                val title = input_title.text.toString()
                val artist = input_artist_name.text.toString()
                val photoUrl = input_image_artist.text.toString()

                if (title == "" || artist == "" || photoUrl == "") {
                    Toast.makeText(
                        view?.context,
                        "Input Data Artis Cann't Be Empty",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    artistViewModel.createNewArtist(
                        Artist(
                            name = artist,
                            title = title,
                            photoUrl = photoUrl
                        )
                    )
                    Toast.makeText(
                        view?.context,
                        "Success Add New Artist!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
