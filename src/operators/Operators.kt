package operators

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun main() {
    //println(findSimilar(arrayOf(1, 2, 3, 4, 5), IntArray(3, init = )))
    val inputA = arrayOf("johny", "tonny", "akhtar", "Roni", "Justine", "Sherrif")
    val inputB = arrayOf("Johny", "jeni", "Uma", "Shoma", "Rajat", " Roni ")
    arrayIntersects2(inputA, inputB)
    println(mostChar("aabbbcccddddaa"))
}

fun findSimilar(a: Array<Int>, b: IntArray): Array<Int>? {
    //if a is bigger than b
    //a ->(1, 2, 3, 4, 5)  b -> (3, 4, 5) ---> should return (3, 4, 5)
    val r = null
    var k = 0
    if (a.size > b.size) {
        for (i in b.indices) {
            for (j in a.indices) {
                if (b[i] == a[j]) {
                    r?.set(k, b[i])
                    k++
                }
            }
        }
    }
    return r

}

//find intersections or common String values between given --> Brute force
fun arrayIntersects(inputA: Array<String>, inputB: Array<String>) {
    for (s in inputA) {
        for (m in inputB) {
            if (s.toLowerCase().trim() == m.toLowerCase().trim()) {
                println(s)
            }
        }
    }
}

fun arrayIntersects2(inputA: Array<String>, inputB: Array<String>) {
    //If we can use another data structure, that will make the checking a bit easier
    //hashmap --> map is key, value. it has .contains
    //hashset --> Set can take the value, it also has .contains which has a runtime of O(1)
    //list --> List does not have such thing, so not appropriate in this case
    val set = HashSet<String>()
    for (s in inputA) {
        set.add(s.toLowerCase().trim())
    }
    for (s in inputB) {
        if (set.contains(s.toLowerCase().trim())) {
            println(s.trim())
        }
    }
}

fun mostChar(input: String): Char {
    if (input.isEmpty()) {
        return 'a'
    }
    var res: Char = input[0]
    val map = HashMap<Char, Int>()
    input.toCharArray().forEachIndexed { _, char ->
        if (map.containsKey(char)) {
            map[char]?.plus(1)?.let { map.put(char, it) }
        } else {
            map[char] = 1
        }
    }
    var best = 1
    map.entries.forEachIndexed { _, mutableEntry ->
        if (mutableEntry.value > best) {
            best = mutableEntry.value
            res = mutableEntry.key
        }
    }
    return res
}