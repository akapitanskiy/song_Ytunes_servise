package uk.saltppay.android_developer_challenge_ntunfd.di.module

import dagger.Binds
import dagger.Module
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.ISongsRepository
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.SongsRepository
import javax.inject.Singleton

@Module
interface IRepositoryModuleBinder {

    @Binds
    @Singleton
    fun bindSongsRepository(
        impl: SongsRepository
    ): ISongsRepository

}