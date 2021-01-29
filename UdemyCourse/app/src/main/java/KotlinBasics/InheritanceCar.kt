package KotlinBasics

// super class
open class ParentCar(val name: String, val brand: String) {
    // "open" makes inheritable because in default, class would be final

}

// sub class
class ElectricCar(name: String, brand: String, batteryLife: Double = 0.0)
    : ParentCar(name, brand) {

}