package KotlinBasics

data class User(val id: Long, var name: String)

fun main() {
    val user1 = User(1, "Denis")

    println(user1.name)
    user1.name = "Michael"
    println(user1.name)

    val user2 = User(1, "Michael")
    println(user1.name)
    println(user2.name)
    println(user1.name == user2.name)

    val updatedUser = user1.copy(name = "Jack")
    println(user1)
    println(updatedUser)

    println(updatedUser.component1())
    println(updatedUser.component2())

    val (id, name) = updatedUser
    println("id = $id, name = $name")
}