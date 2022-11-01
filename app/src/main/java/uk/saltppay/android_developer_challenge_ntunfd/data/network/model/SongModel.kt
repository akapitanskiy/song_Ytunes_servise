package uk.saltppay.android_developer_challenge_ntunfd.data.network.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "songs_table", indices = [Index(value = ["itunesId"], unique = true)])
data class SongModel(

    @SerializedName("im:name")
    val songName: NestedLabel?,

    @SerializedName("im:itemCount")
    val itemCount: NestedLabel?,

    val rights: NestedLabel?,

    val title: NestedLabel?,

    @SerializedName("id")
    val itunesId: ItunesId?,
) {
    @PrimaryKey(autoGenerate = true)
    var dbId: Long = -1
}
