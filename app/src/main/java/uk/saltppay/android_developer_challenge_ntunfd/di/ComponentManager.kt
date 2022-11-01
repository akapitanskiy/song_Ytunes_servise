package uk.saltppay.android_developer_challenge_ntunfd.di

import android.content.Context
import uk.saltppay.android_developer_challenge_ntunfd.di.component.AppComponent
import uk.saltppay.android_developer_challenge_ntunfd.di.component.DaggerAppComponent
import uk.saltppay.android_developer_challenge_ntunfd.di.component.ViewModelComponent
import uk.saltppay.android_developer_challenge_ntunfd.di.module.AppModuleProvider

object ComponentManager {

    private lateinit var appComponent: AppComponent
    private var viewModelComponent: ViewModelComponent? = null

    fun initAppComponent(context: Context) {
        appComponent = DaggerAppComponent
            .builder()
            .appModuleProvider( AppModuleProvider(context) )
            .build()
    }

    fun getViewModelComponent(): ViewModelComponent {
        if (viewModelComponent == null) {
            viewModelComponent = appComponent.plusViewModelComponent()
        }
        return viewModelComponent!!
    }

}