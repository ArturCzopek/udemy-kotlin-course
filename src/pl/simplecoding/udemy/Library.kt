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

    /**
     * 3.6 - functions
     * function which print all data about book
     * receives current books amount and new books amount, returns new value
     * one top level function, one inside function
     */

    fun bookInfo(title: String, author: String, releaseYear: Int, publisher: String?) {
        println("'" + title + "', author: " + author + ", release year: " + releaseYear + ", " + (publisher ?: "Not known"))
    }

    bookInfo(title, author, releaseYear, publisher)
    println("Order 10 books")
    val newOrderedBooks = orderedBooksAmount(booksInMagazine, 10)
    println("New amount: " + newOrderedBooks)
}

fun orderedBooksAmount(currentAmount: Int, newAmount: Int)= currentAmount + newAmount
