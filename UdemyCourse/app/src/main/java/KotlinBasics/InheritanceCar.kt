package KotlinBasics

// super class
open class ParentCar(
    override val maxSpeed: Double,
    val name: String,
    val brand: String
) : Drivable {
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

    override fun drive(): String {
        return "driving the interface"
    }
}

// sub class
class ElectricCar(
    maxSpeed: Double,
    name: String,
    brand: String, batteryLife: Double = 0.0
) : ParentCar(maxSpeed, name, brand) {

    override var range = batteryLife * 6

    override fun drive(distance: Double) {
        println("Drove for $distance KM on electricity")
    }

    override fun drive(): String {
        return "Drove for $range KM on electricity"
    }

    override fun brake() {
        super.brake() //to call function of the super class
    }
}

fun main() {
    var myCar = ParentCar(200.0, "A3", "Audi")
    var myECar = ElectricCar(200.0, "S-Model", "Tesla", 85.0)
    myECar.extendRange(200.0)
    myCar.drive(200.0)
    myECar.drive(myECar.range)
    println(myECar.drive())

}