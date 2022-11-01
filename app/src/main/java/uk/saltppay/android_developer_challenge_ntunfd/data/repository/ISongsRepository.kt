package uk.saltppay.android_developer_challenge_ntunfd.data.repository

import io.reactivex.Flowable
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel

interface ISongsRepository {

//    fun deleteAllSongs(): Maybe<Int>

    fun getSongsAndObserveDb(): Flowable<List<SongModel>>
}