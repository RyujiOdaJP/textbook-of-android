package KotlinBasics

interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking")
    }

    /*
    * Differences between interface and abstract class
    * 1. Abstract class can be inherited by sub classes, Interface can be multiple implemented by only one class
    * 2. Abstract class can have constructors but interface not.
    * 3. Interface cannot hold state as field (member variables)
    *  */
}