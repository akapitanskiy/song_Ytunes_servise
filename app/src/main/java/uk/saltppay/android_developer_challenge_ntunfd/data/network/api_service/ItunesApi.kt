package uk.saltppay.android_developer_challenge_ntunfd.data.network.api_service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import uk.saltppay.android_developer_challenge_ntunfd.data.network.model.Response

interface ItunesApi {

    @GET("us/rss/topalbums/limit={qty}/json")
    fun getSongList(
        @Path("qty") limitQty: Long
    ): Single<Response>
}