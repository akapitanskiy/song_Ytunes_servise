package uk.saltppay.android_developer_challenge_ntunfd.ui.songs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.schedulers.Schedulers
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.ISongsRepository
import uk.saltppay.android_developer_challenge_ntunfd.ui.CommonViewModel
import javax.inject.Inject

class SongListViewModel @Inject constructor(
    private val repository: ISongsRepository
) : CommonViewModel() {

    private val TAG = this::class.java.simpleName
    private val songsLiveData = MutableLiveData<List<SongModel>>()

    private fun getAndObserveDb() {
        repository.getSongsAndObserveDb()
            .subscribeOn(Schedulers.io())
            .subscribe(
                songsLiveData::postValue
            ) { Log.d(TAG, "getAndObserveDb: ${it.message}") }
            .also{ disposable.add(it) }
    }

    fun getSongsLiveData(): LiveData<List<SongModel>> {
        getAndObserveDb()
        return songsLiveData
    }

}

