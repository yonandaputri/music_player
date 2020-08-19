package com.example.music_player.song.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.music_player.R
import com.example.music_player.song.recyclerAdapter.SongRecycleAdapter
import com.example.music_player.song.viewModel.SongViewModel
import kotlinx.android.synthetic.main.fragment_list_song.*

/**
 * A simple [Fragment] subclass.
 * Use the [ListSong.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListSong : Fragment() {

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
        return inflater.inflate(R.layout.fragment_list_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_recyclerView.layoutManager = LinearLayoutManager(activity)
        songRecycleAdapter =
            SongRecycleAdapter(
                songViewModel.songLiveData.value!!
            )
        song_recyclerView.adapter = songRecycleAdapter

        songViewModel.songLiveData.observe(viewLifecycleOwner, Observer {
            println(it.joinToString())
            songRecycleAdapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_listSong_to_addSong)
        }
    }
}

