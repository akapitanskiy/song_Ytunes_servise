package uk.saltppay.android_developer_challenge_ntunfd.data.repository

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uk.saltppay.android_developer_challenge_ntunfd.data.db.ItunesDao
import uk.saltppay.android_developer_challenge_ntunfd.data.network.api_service.ItunesApi
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.Response
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel
import javax.inject.Inject

class SongsRepository @Inject constructor(
    private val itunesApi: ItunesApi,
    private val itunesDao: ItunesDao
): ISongsRepository {

    private val TAG = this::class.java.simpleName
    private val disposable = CompositeDisposable()

    override fun getSongsAndObserveDb(): Flowable<List<SongModel>> {
        getSongsFromNetworkAndUpdateDb()
        return itunesDao.getSongs()
    }

    private fun getSongsFromNetworkAndUpdateDb() {
        itunesApi.getSongList(100)
            .subscribeOn(Schedulers.io())
            .subscribe(
                this::insertToDb
            ) { Log.d(TAG, "getSongs: ${it.message}") }
            .also{ disposable.add(it) }
    }

    private fun insertToDb(response: Response?) {
        response?.feed?.entry ?: return

        itunesDao.insert( response.feed.entry )
            .subscribe(
                { Log.d(TAG, "insert: inserted ${it.size}") },
                { Log.d(TAG, "insert: ${it.message}") }
            )
            .also{ disposable.add(it) }
    }

//    override fun deleteAllSongs(): Maybe<Int> {
//        return itunesDao.deleteAllSongs()
//    }
}