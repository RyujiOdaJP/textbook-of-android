package KotlinBasics

// super class
open class ParentCar(val name: String, val brand: String) {
    // "open" makes inheritable because in default, class would be final by default
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }
    }

    open fun drive(distance: Double) {
        println("Drove for $distance km")
    }
}

// sub class
class ElectricCar(name: String, brand: String, batteryLife: Double = 0.0) : ParentCar(name, brand) {
    override var range = batteryLife * 6
    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }
}

fun main() {
    var myCar = ParentCar("A3", "Audi")
    var myECar = ElectricCar("S-Model", "Tesla", 85.0)
    myECar.extendRange(200.0)
    myCar.drive(200.0)
    myECar.drive(myECar.range)

}