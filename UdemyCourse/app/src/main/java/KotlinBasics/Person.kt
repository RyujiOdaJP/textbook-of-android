package KotlinBasics

fun main() {
    val denis = Person("Denis", "Panjuta")
    denis.hobby = "skateboard"
    denis.stateHobby()
}

class Person (var firstName: String = "John", lastName: String = "Doe") {

    var age: Int? = null
    var hobby = "Netflix"

    init {
        println("Initialized a new Person object with " +
        "firstName = $firstName and lastName = $lastName and age = $age")
    }

    fun stateHobby() {
        println("$firstName hobby is $hobby")
    }
}