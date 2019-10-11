fun main() {
    val list1 = listOf(1, 2, 4)
    list1.allNonZero()
    list1.allNonZero1()
    list1.allNonZero2()

    !list1.containsZero()
    !list1.containsZero1()
    !list1.containsZero2()
}

fun List<Int>.allNonZero() = all { it != 0 }
fun List<Int>.allNonZero1() = none { it == 0 }
fun List<Int>.allNonZero2() = !any { it == 0 }

fun List<Int>.containsZero() = !all { it != 0 }
fun List<Int>.containsZero1() = !none { it == 0 }
fun List<Int>.containsZero2() = any { it == 0 }
