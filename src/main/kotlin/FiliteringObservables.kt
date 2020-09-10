import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject

fun filterObservable() {

    // Ignore all elements
    exampleOf("ignoreElements")
    {

        val subscriptions = CompositeDisposable()
        val cannedProjects = PublishSubject.create<String>()

        subscriptions.add(cannedProjects
            .ignoreElements()
            .subscribeBy {
                println("Completed")
            })
        cannedProjects.onNext(landOfDroids)
        cannedProjects.onNext(wookieWorld)
        cannedProjects.onNext(detours)

        cannedProjects.onComplete()


    }

    exampleOf("elementAt")
    {
        val subscriptions = CompositeDisposable()
        val quotes = PublishSubject.create<String>()
        subscriptions
            .add(quotes
                .elementAt(2)
                .subscribeBy(
                    onSuccess = { println(it) }, // subscribe with onSuccess instead on Next
                    onComplete = { println("Completed") }
                ))

        quotes.onNext(mayTheOdds)
        quotes.onNext(liveLongAndProsper)
        quotes.onNext(mayTheForce)
    }

    exampleOf("filter")
    {
        val subscriptions = CompositeDisposable()
        subscriptions.add(
            Observable.fromIterable(_tomatometerRatings)
                .filter { movie ->
                    movie.rating >= 90
                }.subscribe { println(it) }
        )
    }
    exampleOf("SkipWhile")
    {
        val subscriptions = CompositeDisposable()

        subscriptions.add(
            Observable.fromIterable(_tomatometerRatings)
                .skipWhile { movie ->
                    // skip until this condition fail
                    movie.rating < 90
                } .subscribe {
                    println(it)
                }
        )
    }
}