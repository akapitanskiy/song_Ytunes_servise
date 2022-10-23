package uk.saltppay.android_developer_challenge_ntunfd.data.network.model

import com.google.gson.annotations.SerializedName

data class SongModel(

    @SerializedName("im:name")
    val songName: NestedLabel?,

    @SerializedName("im:itemCount")
    val itemCount: NestedLabel?,

    val rights: NestedLabel?,

    val title: NestedLabel?,
)
