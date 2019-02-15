package pl.simplecoding.udemy

import java.time.LocalDateTime

/**
 * 4.2 - basic class
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

/**
 * 4.3 - data class
 * data class user
 * immutable id - long
 * immutable name - string
 * immutable created - localdatetime
 *
 * library: mutable list of user + method addUser with user name only!
 * id - based on list size
 * user amount - proper getter
 */

/**
 * 4.5 - companion object
 * companion object - user
 * - current id = 1
 * - fun currentUserId - returns id
 *
 * new constructor only with name, main constructor should be private, in new constructor increment comp. obj. id
 */

/**
 * 4.6 - (no)class
 * use config fields
 * store there:
 * - library name - add new field in library
 * - start user id
 */

/**
 * 4.7 - objects, inline objects
 * convert Library to singleton
 */

/**
 * 5.3 - operator functions
 * operator function to add user by modulo operator
 * Library % "User"
 */

/**
 * 5.4 - infix & extension functions
 * create extension function "new" which add book to library
 */

/**
 * 5.5 - named & default parameter
 * add book by using constructor with naming convention
 */

/**
 * 5.6 - collection functions
 * create function which returns books released later than 2000 and sort them descending (you can add some books)
 */

/**
 * 5.7 - functions as objects
 * add function to book as a filed - displayer: (Book) -> String - default implementation displays info about title and author
 * - add display function which gonna use this from above
 * - Library - add function displayBooks - display all books by their display
 * - use those functions
 */
data class User private constructor(val id: Long, val name: String, val created: LocalDateTime) {

    constructor(name: String) : this(currentId, name, LocalDateTime.now()) {
        currentId++
    }

    companion object {
        private var currentId = startUserId

        fun currentUserId() = currentId
    }
}


data class Book(
        val title: String,
        val author: String,
        val releaseYear: Int,
        var available: Boolean = true,
        val displayer: (Book) -> String = {"'${it.title}' - ${it.author}"}
) {
    fun display() = displayer(this)
}
object Library {

    init {
        println("Creating Library")
    }

    val name = libraryName
    val books = mutableListOf<Book>()
    private val users = mutableListOf<User>()

    val usersAmount: Int
        get() = users.size

    fun addUser(name: String) = users.add(User(name))

    operator fun rem(name: String) = this.addUser(name)

    infix fun getBooksReleasedAfter(releaseYear: Int) = books.filter { it.releaseYear > releaseYear }.sortedByDescending { it.releaseYear }

    fun displayBooks() = books.map(Book::display).forEach(::println)
}

fun main(args: Array<String>) {
    val effectiveJava = Book(
            available = false,
            releaseYear = 2001,
            title = "Effective Java",
            author = "Joshua Bloch"
    )

    val effectiveJava2 = Book(
            available = false,
            releaseYear = 2004,
            title = "Effective Java edition 2",
            author = "Joshua Bloch"
    )

    val harryPotter = Book("Harry Potter", "J.K. Rowling", 2000, true) {"xxx ${it.title} xxx"}

    Library new effectiveJava
    Library new effectiveJava2
    Library new harryPotter
    println("Books amount (titles): ${Library.books.size}")
    println("Library name ${Library.name}")

    println("Current id for a new user ${User.currentUserId()}")
    Library % "Artur"
    println("Current id for a new user ${User.currentUserId()}")
    println("Users: ${Library.usersAmount}")

    val booksAfter2000 = Library getBooksReleasedAfter 2000
    booksAfter2000.forEach { println(it) }

    Library.displayBooks()
}
