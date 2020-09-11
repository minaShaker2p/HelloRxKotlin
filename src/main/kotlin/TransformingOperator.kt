import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy

fun transformingOperator() {
     exampleOf("map")
     {
         val subscriptions = CompositeDisposable()

         Observable.fromIterable(episodes)
             .map {
                 val components = it.split(" ").toMutableList()
                 val number = components[1].romanNumeralIntValue()
                 val numberString = number.toString()
                 components[1] =numberString
                 components.joinToString(" ")
             }.subscribeBy {
                 println(it)
             }

     }
}