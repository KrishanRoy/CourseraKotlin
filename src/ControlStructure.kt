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
fun printForLoopIncludeLastIndex(){
    for (i in 1..9){
        print("i: $i ") // should print from 1 to 9
    }
}
fun printForLoopExcludeLastIndex(){
    for (i in 1 until 9){
        print("i: $i ") // pretty obvious.. should print from 1 to 8 and exclude 9
    }
}
fun main (){
    printForLoopWithSteps()
    printCharacterPlusOne()
}
fun printForLoopWithSteps(){
    for (i in 10 downTo 1 step 2){
        print("i stepping two down: $i " )  //should print 10, 8, 6, 4, 2 and then stop
    }
}

fun printCharacterPlusOne(){
    for (ch in "abcd"){
        print(ch + 1) //should print a + 1 --> b and b + 1 --> c etc....(end result --> bcde)
    }
}