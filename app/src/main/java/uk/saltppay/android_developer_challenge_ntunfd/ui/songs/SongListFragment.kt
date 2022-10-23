package uk.saltppay.android_developer_challenge_ntunfd.ui.songs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel
import uk.saltppay.android_developer_challenge_ntunfd.databinding.FragmentSongListBinding
import uk.saltppay.android_developer_challenge_ntunfd.di.ComponentManager
import uk.saltppay.android_developer_challenge_ntunfd.ui.ViewModelFactory
import javax.inject.Inject

class SongListFragment : Fragment() {

    private var _bind: FragmentSongListBinding? = null
    private val bind get() = _bind!!
    private lateinit var songListViewModel: SongListViewModel
    private lateinit var songsAdapter: SongAdapter
    @Inject
    lateinit var vmFactory: ViewModelFactory

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bind = FragmentSongListBinding.inflate(inflater, container, false)

        ComponentManager.getViewModelComponent().inject(this)
        songListViewModel = ViewModelProvider(this, vmFactory).get(SongListViewModel::class.java)

        initRecycler()

        songListViewModel.getSongsLiveData().observe(viewLifecycleOwner, this::handleSongsData)

        return bind.root
    }

    private fun handleSongsData(songs: List<SongModel>?) {
        songsAdapter.submitList(songs)
    }

    private fun initRecycler() {
        bind.songsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        songsAdapter = SongAdapter()
        bind.songsRecyclerView.adapter = songsAdapter
    }


}