package KotlinBasics

fun main() {
    myFunction()
    println(addUp(4, 3))


    val nullAbleName: String? = "Denis"
    nullAbleName?.let { print(it) } //safe call let{}
}

fun myFunction() {
    println("from my function")
}

fun addUp(a: Int, b: Int): Int {
    return a + b
}