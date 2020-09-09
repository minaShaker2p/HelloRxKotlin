import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.BehaviorSubject

// behaviour subject must be initialized at the beginning
fun behaviorSubjectObservable() {
    exampleOf("BehaviorSubject")
    {
        val subscriptions = CompositeDisposable()
        val quotes = BehaviorSubject.createDefault(iAmYourFather)

        val subscriptionOne = quotes.subscribeBy(
            onNext = { printWithLabel("1)", it) },
            onError = { printWithLabel("1)", it.toString()) },
            onComplete = { printWithLabel("1)", "Completed") }
        )
        quotes.onError(Quote.NeverSaidThat())

        subscriptions.add(quotes.subscribeBy(
            onNext = { printWithLabel("2)", it) },
            onError = { printWithLabel("2)", it.toString()) },
            onComplete = { printWithLabel("2)", "Completed") }
        ))
    }
}