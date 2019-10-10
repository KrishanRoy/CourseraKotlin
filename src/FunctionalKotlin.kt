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
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val isEven: (Int) -> Boolean =
        { i: Int -> i % 2 == 0 }
    println(isEven(42)) // should print true
    val Arka = Person("Arka", 24)
    agePredicate(Arka, 19) // prints true

    println(duplicateNonZero(listOf(3, 0, 5))) // will surprisingly return an empty list --> []
    println(duplicateNonZero1(listOf(3, 0, 8)))
    iteratingList(listOf(3, 5, 0, 9))
    println()
    iteratingListSameAsAbove(listOf(3, 5, 0, 9))


}

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?
)

enum class Gender { MALE, FEMALE }

fun isEven(i: Int): Boolean = i % 2 == 0
val predicate = ::isEven //compiler is okay
val predicate1 = { i: Int -> isEven(i) }
val list = listOf(1, 2, 3, 4)
val action = list.any(::isEven) //returns true as 2 and 4 are even
val action1 = list.filter(::isEven) // it will filter even elements and save --> [2,4]

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}

val agePredicate = Person::isOlder

//---------
fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return listOf() // this return will return from the function and not from the lambda
        listOf(it, it)
    }
}

fun duplicateNonZero1(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf<Int>() // this return will return the else case as
        listOf(it, it)
    }
}

fun iteratingList(list: List<Int>) {
    list.forEach {
        if (it == 0) return@forEach
        print(it)
    }
}

fun iteratingListSameAsAbove(list: List<Int>) { // here continue works the same as iteratingList
    for (element in list) {
        if (element == 0) continue
        print(element)
    }
}

