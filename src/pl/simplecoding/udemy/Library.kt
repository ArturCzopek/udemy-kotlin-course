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

    val title: String = "Effective Java"
    val author: String = "Joshua Bloch"
    val releaseYear: Int = 2001
    var booksInMagazine: Int = 0

    println(title)
    println(author)
    println(releaseYear)
    println(booksInMagazine)
    println("Increment")
//    releaseYear++ do not work
    booksInMagazine++
    println(booksInMagazine)
}