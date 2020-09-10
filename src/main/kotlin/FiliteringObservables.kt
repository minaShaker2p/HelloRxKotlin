import io.reactivex.disposables.CompositeDisposable
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
}