package uk.saltppay.android_developer_challenge_ntunfd.di.component

import dagger.Subcomponent
import uk.saltppay.android_developer_challenge_ntunfd.di.module.VMFactoryModuleProvider
import uk.saltppay.android_developer_challenge_ntunfd.ui.MainActivity
import uk.saltppay.android_developer_challenge_ntunfd.ui.songs.SongListFragment

@Subcomponent
    ( modules = [VMFactoryModuleProvider::class] )
interface ViewModelComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: SongListFragment)
}