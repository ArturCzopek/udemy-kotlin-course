package pl.simplecoding.udemy

fun main(args: Array<String>) {
    // 3.2 - val, var
    var simpleInt: Int = 15
    println(simpleInt)

    simpleInt = 14
    println(simpleInt)

    simpleInt = 13
    println(simpleInt)


    val immutableString: String = "Immutable"
    println(immutableString)

//    immutableString = "NEW VALUE"
//    println(immutableString)

    var mutableString = "Mutate me"
    println(mutableString)

    mutableString = "Changed"
    println(mutableString)

//    mutableString = null

}