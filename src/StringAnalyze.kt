object StringAnalyze {
    @JvmStatic
    fun main(args: Array<String>) {
        println(findSmallestDivisor("bcdbcd", "bcd"))
    }

    fun findSmallestDivisor(s: String, t: String): Int {
        val countS: Int
        val countT: Int
        var result = -1
        val divisor: String
        when {
            s == "" || t == "" -> return result
            t.length > s.length -> return result
            s == t -> return t.length
            areBothDivisorsSame(s, t) -> {
                divisor = findSmallestDivisorSubString(s)
                countS = countRepetitions(s, divisor)
                countT = countRepetitions(t, divisor)
                result = try {
                    if (countS % countT == 0) divisor.length
                    else -1
                } catch (e: ArithmeticException) {
                    -1
                }
            }
        }
        return result
    }

    fun countRepetitions(input: String, regex: String): Int {
        return input.split(regex.toRegex()).toTypedArray().size - 1
    }

    fun findSmallestDivisorSubString(s: String): String {
        var j = 0
        var result = ""
        if (s.length < 2) {
            return s
        }
        for (i in 0 until s.length - 1) {
            if (s[0] == s[i + 1]) {
                j = i + 1
                result = s.substring(0, j)
                break
            }
        }
        return if (j > 0 && result == s.substring(j, j + j)) {
            result
        } else result
    }

    fun areBothDivisorsSame(s: String, t: String): Boolean {
        var result = false
        if (containsOnlyRepeatedDivisors(s) && containsOnlyRepeatedDivisors(t)) {
            result = findSmallestDivisorSubString(s) == findSmallestDivisorSubString(t)
        }
        if (containsOnlyRepeatedDivisors(s)) {
            result = findSmallestDivisorSubString(s) == t
        }
        return result
    }

    fun containsOnlyRepeatedDivisors(string: String): Boolean {
        return (string + string).indexOf(string, 1) != string.length
    }
}
