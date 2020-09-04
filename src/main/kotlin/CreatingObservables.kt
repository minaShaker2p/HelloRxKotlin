import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable


fun createObservable()
{
    // observable of string
   val mostPopular : Observable<String> = Observable.just(episodeI)

    // observable of strings
    val originalTrilogy = Observable.just(episodeIV,episodeV,episodeIII)

    // Observable of list
    val prequelTrilogy = Observable.just(listOf(episodeI,episodeII,episodeIII))

    // Observable from ITERABLE
    val sequelTrilogy = Observable.fromIterable(listOf(episodeVI,episodeVII,episodeIX))

    //  Observable from list
    val stories = listOf<String>(solo,rogueOne).toObservable()



}