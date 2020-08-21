package com.example.music_player.song.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.music_player.R
import com.example.music_player.song.recyclerAdapter.ArtistRecycleAdapter
import com.example.music_player.song.recyclerAdapter.SongRecycleAdapter
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
    lateinit var songRecycleAdapter: SongRecycleAdapter

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

        val artistId = arguments?.getInt("artistId")?:1

        songViewModel.getArtistWithSongs(artistId)
        show_title_song.text = arguments?.getString("title")
        Picasso.get().load(arguments?.getString("photoUrl")).into(image_artist_show)

        song_recycler_view.layoutManager = LinearLayoutManager(activity)
        songViewModel.getArtistWithSongs(artistId).observe(viewLifecycleOwner, Observer {
            songRecycleAdapter = SongRecycleAdapter(it)
            song_recycler_view.adapter = songRecycleAdapter
        })

        val bundle = bundleOf(Pair("idArtistSong", artistId))
        add_song_button.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_showMusic_to_addSong, bundle)
        }
    }
}
