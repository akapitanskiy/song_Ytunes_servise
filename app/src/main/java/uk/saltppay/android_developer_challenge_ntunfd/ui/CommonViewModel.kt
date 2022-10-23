package uk.saltppay.android_developer_challenge_ntunfd.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class CommonViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        disposable.clear()
    }
}