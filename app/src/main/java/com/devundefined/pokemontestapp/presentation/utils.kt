package com.devundefined.pokemontestapp.presentation

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun perform(action: () -> Unit): Completable {
    return Completable.fromAction { action() }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <R> load(callable: () -> R): Single<R> {
    return Single.fromCallable { callable() }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}