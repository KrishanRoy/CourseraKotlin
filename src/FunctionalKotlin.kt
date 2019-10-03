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
    println(heroes.lastOrNull()?.name)
    println(heroes.firstOrNull()?.age)
    println(heroes.firstOrNull { it.age == 30 }) //should print null as their is no Heo with an age of 30
    //print(heroes.first{it.age == 30}.name) // throws an exception
    println(heroes.filter { it.age < 30 }[0].name)
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println("youngest size: ${youngest.size} and oldest size : ${oldest.size}")

    println("the maximum aged hero: ${heroes.maxBy { it.age }?.name}")
    println("Check if all the characters' age is less than 50: ${heroes.all { it.age < 50 }}") //should print false
    println("Check if there is any women: ${heroes.any { it.gender == FEMALE }}") //should print true

    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println("the age of Frenchy is: ${mapByName["Frenchy"]?.age}") //42
    println("the age of Frenchy is: ${mapByName.getValue("Frenchy").age}") //42 --> note, we do not need to safe operator here

    val allPossiblePairsFromHero = heroes.flatMap { first: Hero ->
            heroes.map { second -> first to second }
        }
    val (older, younger) = allPossiblePairsFromHero.maxBy { it.first.age - it.second.age }!!
    println(older.age)
    println(younger.age)

}

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender { MALE, FEMALE }

