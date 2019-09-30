import Gender.*

fun main() {
    val heroes = listOf(
        Hero("The Captain", 60, MALE),
        Hero("Frenchy", 42, MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, FEMALE),
        Hero("First Mate", 29, MALE),
        Hero("Sir Stephen", 37, MALE)
    )
    print(heroes.lastOrNull()?.name)
    print(heroes.firstOrNull()?.age)
    print(heroes.firstOrNull { it.age == 30 }) //should print null as their is no Heo with an age of 30
    //print(heroes.first{it.age == 30}.name) // throws an exception
    print(heroes.filter { it.age < 30 }[0].name)
}

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender { MALE, FEMALE }

