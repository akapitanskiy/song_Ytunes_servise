package uk.saltppay.android_developer_challenge_ntunfd.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.ISongsRepository
import uk.saltppay.android_developer_challenge_ntunfd.ui.songs.SongListViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    songsRepository: ISongsRepository,
) : ViewModelProvider.Factory {

    private val songsRepository: ISongsRepository

    init {
        this.songsRepository = songsRepository
    }

    @SuppressWarnings("unchecked")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(SongListViewModel::class.java)) {
            SongListViewModel(songsRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}