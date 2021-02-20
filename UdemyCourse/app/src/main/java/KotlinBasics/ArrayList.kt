package KotlinBasics

open class ArrayList {
    open val emptyList = ArrayList<Int>()
    open val shortArrayList = ArrayList<Int>(4)
    open val list = arrayOf<Int>(1, 2, 3, 4, 5).iterator()
}

fun main() {
    val arrayList = ArrayList()
    println(arrayList.emptyList)
    arrayList.shortArrayList.add(8)
    println(arrayList.shortArrayList)

    while (arrayList.list.hasNext()) {
        println(arrayList.list.next())
    }
    println(arrayList.list)
}