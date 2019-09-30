import java.lang.StringBuilder

fun main1() {
    println("today's weather ${updateWeather(5)}")
    print()
    printMap()
    printSet()
    printListWithIndex()
    printForLoopIncludeLastIndex()
    printForLoopExcludeLastIndex()
}

fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 10 -> Pair("Cold", Color.BLUE)
        degrees < 25 -> Pair("Warm", Color.ORANGE)
        else -> Pair("Hot", Color.RED)
    }

}

fun print() {
    println(
        listOf('a', 'b', 'c').joinToString(
            separator = " ", prefix = "(", postfix = ")"
        )
    )
    println(
        listOf(1, 2, 3).joinToString(
            postfix = "."
        )
    )
}

fun printMap() {
    val map: Map<Int, String> = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    for ((key, value) in map) {
        println("key: $key, value: $value")
    }
}

fun printListWithIndex() {
    val list = listOf(
        1,
        2,
        3
    )
    for ((index, element) in list.withIndex()) {
        println("index: $index, element: $element")
    }
}

fun printSet() {
    val set: Set<Pair<Int, String>> = setOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )
    for ((key, value) in set) {
        println("key: $key, value: $value") //I tried to write setOf instead of mapOf and it still worked due to the Pair<> function
    }
}

fun printForLoopIncludeLastIndex() {
    for (i in 1..9) {
        print("i: $i ") // should print from 1 to 9
    }
}

fun printForLoopExcludeLastIndex() {
    for (i in 1 until 9) {
        print("i: $i ") // pretty obvious.. should print from 1 to 8 and exclude 9
    }
}

fun printForLoopWithSteps() {
    for (i in 10 downTo 1 step 2) {
        print("i stepping two down: $i ")  //should print 10, 8, 6, 4, 2 and then stop
    }
}

fun printCharacterPlusOne() {
    for (ch in "abcd") {
        print(ch + 1) //should print a + 1 --> b and b + 1 --> c etc....(end result --> bcde)
    }
}

fun isValidIdentifierr(input: String): Boolean = (input[0].isLetter() || input[0] == '_' || input.isNotEmpty())

fun main() {
    printForLoopWithSteps()
    printCharacterPlusOne()

    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    unexpectedSum()

    println("    repeating the string five times: ${"ab".repeat(n = 5)}")
    println("repeating the string five times:${"ab".repeat(n = 9)}")

    println("this method should return d: ${"abcd".lastChar()}")
    println("Should print 'b' even though the extension function does otherwise : ${"abc".get(1)}") //Member function gets priority over any extension function
}

fun unexpectedSum() {
    val x: Int? = 5
    val y: Int = 2
    val s1: Int = x ?: 0 + y //it will print only 5 and ignore the rest after the elvis.
    print(s1)
}

fun lambda() {
    val map = hashMapOf<String, Int>()
    map["house"] = 1
    map["room"] = 4
    map["bed"] = 5
    map.mapValues { entry -> "${entry.key}->${entry.value}!" }
}

fun isValidIdentifier(s: String): Boolean {
    val list = listOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')')
    return when {
        s.isEmpty() || s.toCharArray().any { it in list } -> false
        s[0].isLetter() || s[0] == '_' -> true
        else -> false
    }
}

fun String.repeat(n: Int): String {
    val sb = StringBuilder(n * this.length)
    for (i in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}

fun String.lastChar(): Char = get(length - 1)

fun String.get(index: Int): Char = '*' //extension function will not win over the member function

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val allOptions = "ABCDEF"
    //to find the correct position, I am zipping both the secret and the guess and checking if they are same
    val rightPosition = secret.zip(guess).count { it.first == it.second }
    val allCommonLetters = allOptions.sumBy { ch ->
        // Line 11 counts how many times each option happens in both secret and the guess and then takes the lower one
        secret.count { it == ch }.coerceAtMost(guess.count { it == ch })
    }
    //Line 14 is self-explanatory --> we subtract all the rightPositions from all the common numbers to get the misplaced Chars
    val misPlacedLetters = allCommonLetters - rightPosition
    return Evaluation(rightPosition = rightPosition, wrongPosition = misPlacedLetters)

}

fun String.isNice(): Boolean {
    val noBaBeBu = setOf("ba", "be", "bu").none() { this.contains(it) }
    val checkIfItHasThreeVowels = count { it in "aeiou" } >= 3
    val checkIfItHasTwoDoubleConsecutive = zipWithNext().any { it.first == it.second }
    return listOf(noBaBeBu, checkIfItHasThreeVowels, checkIfItHasTwoDoubleConsecutive).count { it } >= 2
}
fun mapMore(){
    // Also immutable by default
    val alphaMap: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3) // Only use in non-critical code-paths
    for ((k, v) in alphaMap) {
        println("Key: $k, Value: $v")
    }
}

