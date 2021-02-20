package KotlinBasics

fun main() {
    println("Hi")

    // Type inference: Kotlin assumes automatically data type.
    val age = 30

    val myStr = "Hello world"
    var firstChar: Char = myStr[0]
    var lastChar: Char = myStr[myStr.length - 1]

    println("last character is " + lastChar) // d

    var result = 5 + 4
    result /= 2.0.toInt() // assign new value into result as result = result /2
    println(result)

    var myNum = 10
    println(myNum++) // increase num by 1 after a row is executed
    println(++myNum) // increase num by 1 before a row is executed

    var x: Any = "string"
    when (x) {
        is Int -> println("$x is Int")
        !is Double -> println("$x is not Double")
    }

    x = 15
    do {
        println(x)
        x++
    } while (x <= 20)
    println("while loop is done")

    for (i in 1 until 10) {
        print(i)
    }

    for (j in 10 downTo 1) {
        print(j)
    }

    for (num in 0 until 10000) {
        if(num == 9001) println("It's over 9000")
    }
}