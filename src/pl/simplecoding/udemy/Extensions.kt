package pl.simplecoding.udemy

fun Garage.addCar(car: Car) = addTransport(car)

infix fun Library.new(book: Book) = this.books.add(book)