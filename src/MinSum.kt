/**
  Given an array of Integers, perform some number k of operations.
  Each operation consists of removing any element from the array,
  dividing it by 2 and inserting the ceiling of that result back into
  the array. Minimize the sim of the elements in the final array.

  Example:
  nums = [10, 20, 7]

  k = 4

  Pick  Pick/2   Ceiling    Result
  Initial Array  ------>    [10, 20, 7]
  7     3.5         4       [10, 20, 4]
  10    5           5       [5, 20, 4]
  20    10          10      [5, 10, 4]
  10    5           5       [5, 5, 4]

  The sum of the final array is 5 + 5 + 4 = 14, and that sum is minimal.

 */

fun main() {
    println(minSum(arrayOf(10, 20, 7), 4))
}

private fun minSum(num: Array<Int>, k: Int): Int {
    var i = 0
    while (i < k) { //checks if we have steps left
        num.sort() // sort the input array every time to find the largest element each time
        num[num.size - 1] = divideNumAndConvert(num[num.size - 1])
        i++
    }
    return addAllElements(num)
}

/**
 * it will divide the input int based on odd or even number
 */
fun divideNumAndConvert(n: Int): Int {
    return when {
        n % 2 == 0 -> n / 2
        else -> if (n == 1) {
            n
        } else (n + 1) / 2
    }
}

/**
 * this will get the sum of the input array
 */
fun addAllElements(num: Array<Int>): Int {
    var result = 0
    num.forEach { i ->
        result += i
    }
    return result
}

