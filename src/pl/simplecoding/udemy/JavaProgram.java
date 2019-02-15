package pl.simplecoding.udemy;

import java.util.List;

public class JavaProgram {

    public static void main(String[] args) {
        User user = new User("Czopo");
        System.out.println(user.component2());
        Library library = Library.INSTANCE;
        User.Companion.currentUserId();
        User.currentUserId();
        library.addUser("Artur");
        List<User> users = library.getUsers();
        System.out.println("Users amount: " + users.size());
        library.getBooks().add(new Book("Harry Potter 2", "J.K. Rowling", 2003, false, book -> "'" + book.getTitle() + "' " + book.getAuthor()));

        System.out.println(library.getBooks().get(0).display());
    }
}
