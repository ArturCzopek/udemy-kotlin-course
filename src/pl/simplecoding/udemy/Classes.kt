package pl.simplecoding.udemy

// 4.2 basic class
open class Car constructor(override val company: String, override val model: String = "Not defined") : Transport {    init {
    println("Init")
}

    open val fullName: String
        get() = "$company $model"

    // 4.5 - companion object
    companion object {
        const val wheels = 4
        fun sayMyName() = println("I'm a car!")
    }
}

class FancyCar(company: String, model: String) : Car(company, model) {
    override val fullName: String
        get() = "I am fancy car! I am $company $model"

    val price = 99999.99

    //    companion object: Car.Companion will not work
}

//class MoreFancyCar(): FancyCar("Company", "Model") // will not work


// 4.3 - data classes
// 5.5 - named & default parameters
data class Plane(override val company: String, override val model: String, val capacity: Int = 100) : Transport {    init {
    println("Creating plane...")
}

    override fun displayName() = "$company $model [capacity: $capacity]"
}

// 4.4 - interfaces
interface Transport {
    val company: String
    val model: String

    fun displayName() = "$company $model"
}

// 4.7 - objects, inline objects
object Garage {
    init {
        println("Creating garage...")
    }

    val transports = mutableListOf<Transport>()

    fun addTransport(transport: Transport) {
        transports.add(transport)
    }

    val transportsInGarage: Int
        get() = transports.size

    fun getLast() = transports.last()

    // 5.3 - operator functions
    operator fun plus(transport: Transport) = this.addTransport(transport)

    // 5.4 - infix & extension functions
    infix fun only(company: String) = transports.filter { it.company == company }

    // 5.6 - collection functions
    fun getGroupedTransportsByClasses() = transports.groupBy { it::class }
}

fun main(args: Array<String>) {
    val car = Car(defaultName, "Model")
    val carWithoutModel = Car("Company2")
    println(car.model)
    println(car.fullName)
    println(carWithoutModel.model)
    println(carWithoutModel.fullName)

    val fancyCar = FancyCar("Fancy", "2000")
    println(fancyCar.model)
    println(fancyCar.fullName)
    println(fancyCar.price)

    val plane = Plane("CheapFlights", "XXX")
    val biggerPlane = plane.copy(capacity = 200)
    println(plane.capacity)
    println(biggerPlane.capacity)

//    val betterCar = car.copy(...) // will not work+

    var transport: Transport = plane
    println("Transport $transport")
    println("Transport ${transport.displayName()}")
    transport = car
    println("Transport ${transport.displayName()}")

    Car.Companion.sayMyName()
    Car.sayMyName()
//    FancyCar.Companion.sayMyName() // will not work
    println("Wheels: ${Car.wheels}")
//    println("Wheels: ${car.wheels}") // will not work

    println(Garage)
    val garage = Garage
    println("Are the same? ${garage === Garage}")
    garage + plane
    garage + biggerPlane
    println("Transports in garage ${garage.transportsInGarage}")
    println("Transports in Garage ${Garage.transportsInGarage}")
    println("Last: ${Garage.getLast()}")

    Garage + object : Transport {
        override val company: String
            get() = "Hawk"
        override val model: String
            get() = "Black"
    }

    println("Transports in garage ${garage.transportsInGarage}")
    println("Transports in Garage ${Garage.transportsInGarage}")

    Garage.addCar(car)
    Garage.addCar(fancyCar)

    // 5.2 - smart cast, type check
    for (transport in Garage.transports) {
        when (transport) {
            is FancyCar -> println("It is fancy car with price ${transport.price}")
            is Plane -> println("It is plane with capacity of ${transport.capacity}")
            else -> println("Transport ${transport::class}")
        }
    }

    val cheapFlights = Garage only "CheapFlights"
    println("Cheap flights in garage: $cheapFlights")

    Garage.getGroupedTransportsByClasses()
            .forEach { key, value -> println("Key: ${key.simpleName}, objects: ${value.map { it.displayName() }}")}

//    listOf<Transport>().add() // will not work

    // 5.7 - functions as objects
    val converter: (String) -> String = { text: String -> "$$$$$text$$$$"}
    val converterTwo: (String) -> String = { "!!!$it!!!"}
    val converterThree = { one: String, two: String -> "!!!$one!!! !!!$two!!!"}
    val converterFour = { word: String, fn: (String) -> String -> fn(word) }
    println(converter("Test"))
    println(converterTwo("Test2"))
    println(converterThree("Test3a", "Test3b"))
    println(converterFour("Test4a", converter))
    println(converterFour("Test4b") {"%$it%"})
    println(Converter().action("Test5"))
    println(Converter(converterTwo).action("Test6"))
    println(Converter { "@$it@" }.action("Test7"))
}

class Converter(val fn: (String) -> String = { "^$it^"}) {
    fun action(word: String) = fn(word)
}
