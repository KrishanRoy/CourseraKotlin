fun main() {
    println(minSum(arrayOf(10, 20, 7), 4))
}

private fun minSum(num: Array<Int>, k: Int): Int {
    var i = 0
    while (i < k) {
        for (j in num.indices) {
            num[j] = divideNumAndConvert(num[j])
            i++
            if (i == k) {
                break
            }
        }
    }
    return addAllElements(num)
}

fun divideNumAndConvert(n: Int): Int {
    return when {
        n % 2 == 0 -> n / 2
        else -> if (n == 1) {
            n
        } else (n + 1) / 2
    }
}

fun addAllElements(num: Array<Int>): Int {
    var result = 0
    num.forEach { i ->
        result += i
    }
    return result
}

