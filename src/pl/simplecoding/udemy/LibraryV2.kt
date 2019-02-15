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


data class User(val id: Long, val name: String, val created: LocalDateTime)

class Book(val title: String, val author: String, val releaseYear: Int, var available: Boolean = true)

class Library {

    init {
        println("Creating Library")
    }

    val books = mutableListOf<Book>()
    private val users = mutableListOf<User>()

    val usersAmount: Int
        get() = users.size

    fun addUser(name: String) = users.add(User(users.size.toLong(), name, LocalDateTime.now()))
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

    library.addUser("Artur")
    println("Users: ${library.usersAmount}")
}