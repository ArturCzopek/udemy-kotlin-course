package pl.simplecoding.udemy


open class Car constructor(val company: String, val model: String = "Not defined") {
    init {
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
}
