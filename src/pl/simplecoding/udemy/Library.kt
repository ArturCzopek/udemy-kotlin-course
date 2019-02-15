package pl.simplecoding.udemy

fun main(args: Array<String>) {
    /**
     * 3.2 - val/var
     * title - immutable - string
     * author - immutable - string
     * release year - immutable - int
     * books in magazine - mutable - int
     * increment last two
     */

    /**
     * 3.5 - type inference
     * remove not needed types
     */

    val title = "Effective Java"
    val author = "Joshua Bloch"
    val releaseYear = 2001
    var booksInMagazine = 0

    println(title)
    println(author)
    println(releaseYear)
    println(booksInMagazine)
    println("Increment")
//    releaseYear++ do not work
    booksInMagazine++
    println(booksInMagazine)

    /**
     * 3.3 - null?
     * publisher - mutable - string - nullable
     * "Not known" if null
     */

    var publisher: String? = "PWN"
    println(publisher)

    publisher = null
    println(publisher ?: "Not known")
}