package KotlinBasics

class NestedExample {

    private var name: String = "Mr X"

    class NestedClass {
        fun printOuter(){
            // this is ok to access by initializing
            println("Output of NestedClass = ${NestedExample().name}")

            // cannot access private member of outer class
            // println(name)
        }
    }

    inner class InnerClass {
        // can access private member of outer class
        fun printOuter(){
            println("Output of InnerClass = $name")
        }
    }
}

fun main() {
    NestedExample().InnerClass().printOuter()
    NestedExample.NestedClass().printOuter()
}