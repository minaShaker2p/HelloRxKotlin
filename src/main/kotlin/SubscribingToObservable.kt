import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun createObservableAndSubscribe() {
    val observable = Observable.just(episodeIV, episodeV, episodeVI)

    //  using subscribe
    observable.subscribe { element ->
        println(element)
    }
    divider()
    // using subscribeBy
    observable.subscribeBy(
        onNext = { println(it) },
        onComplete = { println("Completed") }
    )

}

fun createEmptyObservableAndSubscribe() {
    divider()
    exampleOf("empty")
    {
        val observable = Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = { print(it) },
            onComplete = { print("completed") }
        )
    }
}

fun createObservableAndSubscribeWithDispose() {
    divider()
    exampleOf("dispose")
    {
        val observable = Observable.just(episodeIV, episodeVI, episodeV)

        val subscription = observable.subscribeBy(
            onNext = { print(it) },
            onComplete = { print("completed") }
        )
        // to avoid memory leak should stop your subscription on this Observable
        subscription.dispose()
    }
}

fun createObservableAndSubscribeWithCompositeDisposable() {
    exampleOf("CompositeDisposable")
    {
        val subscriptions = CompositeDisposable()
        subscriptions.addAll(listOf(episodeVI, episodeIV, episodeI)
            .toObservable()
            .subscribe {
                println(it)
            })
    }
}