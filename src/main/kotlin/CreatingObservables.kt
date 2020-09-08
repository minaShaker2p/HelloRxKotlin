import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import java.io.File
import kotlin.text.Charsets.UTF_8


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

fun createSingleObservable() {
    exampleOf("Single")
    {
        val subscriptions = CompositeDisposable()

        fun loadText(fileName: String): Single<String> {
            return Single.create create@{ emitter ->
                val file = File(fileName)
                if (!file.exists()) {
                    emitter.onError(FileReadError.FileNotFound())
                    return@create
                }

                val contents = file.readText(UTF_8)
                emitter.onSuccess(contents)
            }
        }

        val observer = loadText("textFile.txt")
            .subscribe({
                println(it)
            }, {
                println("Error , $it")
            })

        subscriptions.add(observer)
    }

}



