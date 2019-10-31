package generics

fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) destination.add(element)
    }
    return destination
}

fun use3(ints: List<Int?>) {
    ints.filter { it != null && it > 0 }
}