package uk.saltppay.android_developer_challenge_ntunfd.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import uk.saltppay.android_developer_challenge_ntunfd.data.network.api_service.ItunesApi
import javax.inject.Singleton

@Module
class ApiModuleProvider {

    @Provides
    @Singleton
    fun provideItunesApi(
        retrofit: Retrofit
    ): ItunesApi {
        return retrofit.create(ItunesApi::class.java)
    }
}