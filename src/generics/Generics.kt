package generics

fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) destination.add(element)
    }
    return destination
}

//comparable upper bound
fun <T : Comparable<T>> maxOf(first: T, second: T): T {
    return if (first > second) first else second
}

fun use3(ints: List<Int?>) {
    ints.filter { it != null && it > 0 }
}

fun main() {
    println(maxOf(5, 8)) //should print 8

}

fun List<Int>.average(): Double {
    return 1.9
}

@JvmName("averageOfDouble")
fun List<Double>.average(): Double {
    return 5.9
}

