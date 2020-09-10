fun exampleOf(description: String, action: () -> Unit) {
    println("\n--- Example of: $description ---")
    action()
}

sealed class Quote : Throwable() {
    class NeverSaidThat : Quote()
}


const val episodeI = "The Phantom Menace"
const val episodeII = "Attack of the Clones"
const val theCloneWars = "The Clone Wars"
const val episodeIII = "Revenge of the Sith"
const val solo = "Solo: A Star Wars Story"
const val rogueOne = "Rogue One: A Star Wars Story"
const val episodeIV = "A New Hope"
const val episodeV = "The Empire Strikes Back"
const val episodeVI = "Return of the Jedi"
const val episodeVII = "The Force Awakens"
const val episodeVIII = "The Last Jedi"
const val episodeIX = "Episode IX"

const val itsNotMyFault = "It’s not my fault."
const val doOrDoNot = "Do. Or do not. There is no try."
const val lackOfFaith = "I find your lack of faith disturbing."
const val eyesCanDeceive = "Your eyes can deceive you. Don’t trust them."
const val stayOnTarget = "Stay on target."
const val iAmYourFather = "Luke, I am your father"
const val useTheForce = "Use the Force, Luke."
const val theForceIsStrong = "The Force is strong with this one."
const val mayTheForceBeWithYou = "May the Force be with you."
const val mayThe4thBeWithYou = "May the 4th be with you."


const val landOfDroids = "Land of Droids"
const val wookieWorld = "Wookie World"
const val detours = "Detours"

const val mayTheOdds = "And may the odds be ever in your favor"
const val liveLongAndProsper = "Live long and prosper"
const val mayTheForce = "May the Force be with you"

data class Movie(val title: String, val rating: Int)

val _episodeI = Movie("The Phantom Menace", 55)
val _episodeII = Movie("Attack of the Clones", 66)
val _episodeIII = Movie("Revenge of the Sith", 79)
val _rogueOne = Movie("Rogue One", 85)
val _episodeIV = Movie("A New Hope", 93)
val _episodeV = Movie("The Empire Strikes Back", 94)
val _episodeVI = Movie("Return Of The Jedi", 80)
val _episodeVII = Movie("The Force Awakens", 93)
val _episodeVIII = Movie("The Last Jedi", 91)
val _tomatometerRatings = listOf(
    episodeI, episodeII, episodeIII, rogueOne, episodeIV, episodeV, episodeVI, episodeVII, episodeVIII
)


fun divider() {
    println("------------------------------------------------------------------")
}

fun <T> printWithLabel(label: String, message: T?) {
    println("$label $message")
}