package KotlinBasics

import java.util.*

fun main() {
    var myCar = Car()
    println("brand is ${myCar.myBrand}")
    myCar.maxSpeed = -1
    println("maxSpeed is ${myCar.maxSpeed}")
}

class Car {
    val myBrand = "BMW"
    get() { // if called getter from somewhere, return value with following statement
        return field.toLowerCase(Locale.ROOT)
    }

    var maxSpeed = 250
        set (value) {
            field = if (value >= 0) value else throw IllegalArgumentException("maxSpeed should not be less than 0")
        }
// getter and setter running in background as below
//    get() = field
//    set(value) {
//        field = value
//    }
    // custom setter

}