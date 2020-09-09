import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.ReplaySubject

fun replaySubjectObservable() {
    exampleOf("ReplaySubject") {
        val subscriptions = CompositeDisposable()
        val subject = ReplaySubject.createWithSize<String>(2)

        subject.onNext(useTheForce)
        subscriptions.add(subject.subscribeBy(
            onNext = { printWithLabel("1)", it) },
            onError = { printWithLabel("1)", it) },
            onComplete = { printWithLabel("1)", "Completed") }
        ))
        subject.onNext(theForceIsStrong)
        subscriptions.add(subject.subscribeBy(
            onNext = { printWithLabel("2)", it) },
            onError = { printWithLabel("2)", it) },
            onComplete = { printWithLabel("2)", "Completed") }
        ))

        subject.onNext(theCloneWars)

        subscriptions.add(subject.subscribeBy(
            onNext = { printWithLabel("3)", it) },
            onError = { printWithLabel("3)", it) },
            onComplete = { printWithLabel("3)", "Completed") }
        ))
    }

}