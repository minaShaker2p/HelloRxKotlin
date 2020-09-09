import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject

fun createPublishSubject() {
    exampleOf("PublishSubject") {
        val episodes = PublishSubject.create<String>()
        episodes.onNext(episodeIV)

        val subscriptionOne = episodes.subscribeBy(
            onNext = { printWithLabel("1)", it) },
            onComplete = { printWithLabel("1)", "Completed") }
        )
        episodes.onNext(episodeV)

        val subscriptionTwo= episodes.subscribeBy(
            onNext = { printWithLabel("2)", it) },
            onComplete = { printWithLabel("2)", "Completed") }
        )

        episodes.onNext(episodeIII)
        subscriptionOne.dispose()

        val subscriptionThree= episodes.subscribeBy(
            onNext = { printWithLabel("3)", it) },
            onComplete = { printWithLabel("3)", "Completed") }
        )
        episodes.onNext(episodeII)
        episodes.onComplete()

        subscriptionTwo.dispose()
        subscriptionThree.dispose()

    }
}