/**
 * similar to extension functions, we can use extension properties with
 * similar syntax like extension functions.
 */
fun String.exFunctionLastIndex(): Int {
    return this.length - 1
}
val String.exPropertyLastIndex: Int
    get() = this.length - 1

val String.indices: IntRange
    get() = 0..lastIndex

fun main() {
    println("abx".exPropertyLastIndex) //should print 2
    println("abx".exFunctionLastIndex()) //should print 2
    println("abcde".indices) //should print 0..4
}