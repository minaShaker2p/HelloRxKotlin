import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just("Hello , Rxkoltin").subscribe {
        print(it)
    }
}