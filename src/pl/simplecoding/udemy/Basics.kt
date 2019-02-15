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

    // 3.3 - null?
    var nullableString: String? = "I may be null"
    println(nullableString)

    nullableString = null
    println(nullableString)

    println("Length of mutable string: " + mutableString.length)
    println("Length of nullable string: " + (nullableString?.length ?:0))

    // 3.4 - basic types
    // 3.5 - type inference
    var anyNumber: Number = 1
    anyNumber = 1.0
    var anyInt = 1
    val bigDouble = 1_000_000.333_333
    println(anyNumber)
    println(anyInt)
    println(bigDouble)

    val simpleArray = arrayOf("First", "Second")
    println(simpleArray)

    var anyObject: Any = 1
    println(anyObject)
    anyObject = "Now I am string"
    println(anyObject)

    // 3.6 - functions
    val functionClass = FunctionClass()
    val fnInt = functionClass.returnsInt()
    val fnInt2 = functionClass.expressionInt()
    val fnMsg = functionClass.anotherString("Hello!")
    println(fnInt)
    println(fnInt2)
    println(fnMsg)

    topLevelFunctionReturnsUnit()
    println(insideCalculation(2, 3))

}

class FunctionClass {
    fun returnsInt(): Int {
        return 3
    }

    fun expressionInt(): Int = 3

    fun anotherString(message: String) = message
}

fun topLevelFunctionReturnsUnit() {
    println("Hello!")
    println("I return nothing! :(")
}

fun insideCalculation(a: Int, b: Int): Int {

    fun insideFun(c: Int, d: Int) = c + d

    println("Call inside")
    return insideFun(a, b)
}