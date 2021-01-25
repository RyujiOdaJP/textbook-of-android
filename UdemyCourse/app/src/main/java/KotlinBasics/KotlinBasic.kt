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
    print(result)
}