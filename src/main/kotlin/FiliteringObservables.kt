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
}