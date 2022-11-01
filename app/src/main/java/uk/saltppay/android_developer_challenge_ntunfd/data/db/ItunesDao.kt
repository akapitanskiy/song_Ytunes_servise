package uk.saltppay.android_developer_challenge_ntunfd.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel

@Dao
interface ItunesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(songs: List<SongModel>): Single<List<Long>>

    @Query("SELECT * FROM songs_table")
    fun getSongs(): Flowable<List<SongModel>>

    @Query("DELETE FROM songs_table")
    fun deleteAllSongs(): Maybe<Int>

}