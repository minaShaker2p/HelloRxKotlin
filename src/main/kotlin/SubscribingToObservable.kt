import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy

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
    exampleOf("empty")
    {
        val observable =Observable.empty<Unit>()

        observable.subscribeBy(
            onNext = { print(it)},
            onComplete = { print("completed")}
        )
    }
}