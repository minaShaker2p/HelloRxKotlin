import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


sealed class Droid : Throwable() {
    class OU812 : Droid()
}

sealed class FileReadError : Throwable() {
    class FileNotFound : FileReadError()
}


fun createObservable() {
    // observable of string
    val mostPopular: Observable<String> = Observable.just(episodeI)

    // observable of strings
    val originalTrilogy = Observable.just(episodeIV, episodeV, episodeIII)

    // Observable of list
    val prequelTrilogy = Observable.just(listOf(episodeI, episodeII, episodeIII))

    // Observable from ITERABLE
    val sequelTrilogy = Observable.fromIterable(listOf(episodeVI, episodeVII, episodeIX))

    //  Observable from list
    val stories = listOf<String>(solo, rogueOne).toObservable()

    //  Create Observable using create operator
    exampleOf("create")
    {
        val subscriptions = CompositeDisposable()
        val versions = Observable.create<String> { emitter ->
            emitter.onNext("Android 11")
            emitter.onNext("Android 10")
            emitter.onNext("Android Pie")
            emitter.onNext("Android Nougat")
        }

        val observer = versions.subscribeBy(
            onNext = { println(it) },
            onError = { println("Error , $it") },
            onComplete = { println("Completed") }
        )
        subscriptions.add(observer)
    }
}



