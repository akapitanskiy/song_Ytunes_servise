package uk.saltppay.android_developer_challenge_ntunfd.data.repository

import io.reactivex.Single
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.Response

interface ISongsRepository {

    fun getSongList(): Single<Response>
}