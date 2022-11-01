package uk.saltppay.android_developer_challenge_ntunfd.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.SongModel

@Database(entities = [SongModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class ItunesDatabase : RoomDatabase() {

    companion object {
        const val ITUNES_DB_FILE_NAME = "saltplay_itunes.db"
    }

    abstract fun getItunesDao(): ItunesDao
}