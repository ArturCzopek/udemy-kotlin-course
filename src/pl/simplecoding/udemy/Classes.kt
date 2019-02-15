package pl.simplecoding.udemy

// 4.2 basic class
open class Car constructor(override val company: String, override val model: String = "Not defined") : Transport {    init {
    println("Init")
}

    open val fullName: String
        get() = "$company $model"
}

class FancyCar(company: String, model: String) : Car(company, model) {
    override val fullName: String
        get() = "I am fancy car! I am $company $model"

    val price = 99999.99
}

//class MoreFancyCar(): FancyCar("Company", "Model") // will not work


// 4.3 - data classes
data class Plane(override val company: String, override val model: String, val capacity: Int) : Transport {    init {
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

fun main(args: Array<String>) {
    val car = Car("company", "Model")
    val carWithoutModel = Car("Company2")
    println(car.model)
    println(car.fullName)
    println(carWithoutModel.model)
    println(carWithoutModel.fullName)

    val fancyCar = FancyCar("Fancy", "2000")
    println(fancyCar.model)
    println(fancyCar.fullName)
    println(fancyCar.price)

    val plane = Plane("CheapFlights", "XXX", 100)
    val biggerPlane = plane.copy(capacity = 200)
    println(plane.capacity)
    println(biggerPlane.capacity)

//    val betterCar = car.copy(...) // will not work+

    var transport: Transport = plane
    println("Transport $transport")
    println("Transport ${transport.displayName()}")
    transport = car
    println("Transport ${transport.displayName()}")
}
