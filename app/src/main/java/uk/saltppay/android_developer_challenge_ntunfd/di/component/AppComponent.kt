package uk.saltppay.android_developer_challenge_ntunfd.di.component

import dagger.Component
import uk.saltppay.android_developer_challenge_ntunfd.di.module.ApiModuleProvider
import uk.saltppay.android_developer_challenge_ntunfd.di.module.AppModuleProvider
import uk.saltppay.android_developer_challenge_ntunfd.di.module.IRepositoryModuleBinder
import uk.saltppay.android_developer_challenge_ntunfd.ui.songs.SongListViewModel
import javax.inject.Singleton

@Singleton
@Component( modules = [
    AppModuleProvider::class,
    IRepositoryModuleBinder::class,
    ApiModuleProvider::class
] )
interface AppComponent {

    fun plusViewModelComponent(): ViewModelComponent
    fun inject(viewModel: SongListViewModel)

}