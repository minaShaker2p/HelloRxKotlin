import io.reactivex.Observable

fun main(args: Array<String>) {

    createObservableAndSubscribe()
    createEmptyObservableAndSubscribe()
    createObservableAndSubscribeWithCompositeDisposable()
    createObservable()
}