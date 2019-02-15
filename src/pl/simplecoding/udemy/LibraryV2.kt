package pl.simplecoding.udemy

/**
 * 4.2
 * class book
 * immutable title - string
 * immutable author - string
 * immutable release year - string
 * mutable is available - boolean, default is true
 *
 * class library
 * no constructor
 * list of books - mutable!
 *
 * create books and library and add boks to library
 * print books amount in library
 * */

class Book(val title: String, val author: String, val releaseYear: Int, var available: Boolean = true)

class Library {

    init {
        println("Creating Library")
    }

    val books = mutableListOf<Book>()
}

fun main(args: Array<String>) {
    val effectiveJava = Book(
            available = false,
            releaseYear = 2001,
            title = "Effective Java",
            author = "Joshua Bloch"
    )

    val harryPotter = Book("Harry Potter", "J.K. Rowling", 2000)

    val library = Library()
    library.books.add(effectiveJava)
    library.books.add(harryPotter)
    println("Books amount (titles): ${library.books.size}")
}