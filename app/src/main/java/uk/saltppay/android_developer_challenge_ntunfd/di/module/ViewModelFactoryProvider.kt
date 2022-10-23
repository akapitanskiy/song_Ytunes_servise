package uk.saltppay.android_developer_challenge_ntunfd.di.module

import dagger.Module
import dagger.Provides
import uk.saltppay.android_developer_challenge_ntunfd.data.repository.ISongsRepository
import uk.saltppay.android_developer_challenge_ntunfd.ui.ViewModelFactory

@Module
class VMFactoryModuleProvider {

    @Provides
    fun provideViewModelFactory(
        songsRepository: ISongsRepository,
    ): ViewModelFactory {
        return ViewModelFactory(
            songsRepository,
        )
    }

}