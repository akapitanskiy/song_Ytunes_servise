package uk.saltppay.android_developer_challenge_ntunfd.data.repository

import io.reactivex.Single
import uk.saltppay.android_developer_challenge_ntunfd.data.network.api_service.ItunesApi
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.Response
import javax.inject.Inject

class SongsRepository @Inject constructor(
    private val itunesApi: ItunesApi
) : ISongsRepository {

    override fun getSongList(): Single<Response> {
        return itunesApi.getSongList(100)
    }
}