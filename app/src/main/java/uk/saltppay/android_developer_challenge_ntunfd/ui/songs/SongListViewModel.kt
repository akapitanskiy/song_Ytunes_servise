package uk.saltppay.android_developer_challenge_ntunfd.ui.songs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.schedulers.Schedulers
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.Response
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.ISongsRepository
import uk.saltppay.android_developer_challenge_ntunfd.ui.CommonViewModel
import javax.inject.Inject

class SongListViewModel @Inject constructor(
    private val repository: ISongsRepository
) : CommonViewModel() {

    private val TAG = this::class.java.simpleName
    private val songsLiveData = MutableLiveData<List<SongModel>?>()

    private fun getSongs() {
        repository.getSongList()
            .subscribeOn(Schedulers.io())
            .subscribe(
                this::onGetSongsSuccess
            ) { Log.d(TAG, "getSongs: ${it.message}") }
            .also{ disposable.add(it) }
    }

    private fun onGetSongsSuccess(response: Response) {
        songsLiveData.postValue( response.feed?.entry )
    }

    fun getSongsLiveData(): LiveData<List<SongModel>?> {
        if (songsLiveData.value == null) {
            getSongs()
        }
        return songsLiveData
    }

}

