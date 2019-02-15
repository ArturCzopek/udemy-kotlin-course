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
 * 5.3 - operator function to add user by modulo operator
 * Library % "User"
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

class Book(val title: String, val author: String, val releaseYear: Int, var available: Boolean = true)

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
}

fun main(args: Array<String>) {
    val effectiveJava = Book(
            available = false,
            releaseYear = 2001,
            title = "Effective Java",
            author = "Joshua Bloch"
    )

    val harryPotter = Book("Harry Potter", "J.K. Rowling", 2000)

    Library.books.add(effectiveJava)
    Library.books.add(harryPotter)
    println("Books amount (titles): ${Library.books.size}")
    println("Library name ${Library.name}")

    println("Current id for a new user ${User.currentUserId()}")
    Library % "Artur"
    println("Current id for a new user ${User.currentUserId()}")
    println("Users: ${Library.usersAmount}")
}