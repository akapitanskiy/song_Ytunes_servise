package uk.saltppay.android_developer_challenge_ntunfd.ui.songs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel
import uk.saltppay.android_developer_challenge_ntunfd.databinding.ItemSongBinding

class SongAdapter : ListAdapter<SongModel, SongAdapter.SongItem>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SongModel>() {

            override fun areItemsTheSame(oldSong: SongModel, newSong: SongModel): Boolean {
                return oldSong.itunesId?.label == newSong.itunesId?.label
                    && oldSong.dbId            == newSong.dbId
            }
            override fun areContentsTheSame(oldSong: SongModel, newSong: SongModel): Boolean {
                return oldSong.itemCount?.label == newSong.itemCount?.label
                    && oldSong.rights?.label    == newSong.rights?.label
                    && oldSong.songName?.label  == newSong.songName?.label
                    && oldSong.title?.label     == newSong.title?.label
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongItem {
        val inflater = LayoutInflater.from(parent.context)
        return SongItem(ItemSongBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SongItem, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class SongItem(private val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SongModel) {
            binding.title.text = item.title?.label
            binding.rights.text = item.rights?.label
            binding.count.text = item.itemCount?.label
        }
    }

}