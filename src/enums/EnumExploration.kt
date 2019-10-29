package enums

import enums.Color.*

enum class Color(val r: Int,  val g: Int,  val b: Int) {
    BLUE(0, 0, 255),
    ORANGE(255, 165, 0),
    GREEN(255, 0, 0);

    fun rgb() = (r * 255 + g) * 256 + b
}

fun getDescription(color: Color) {
    when (color) {
        BLUE -> println("this is blue")
        ORANGE -> println("This is Orange")
        GREEN -> println("This is Green")
    }
}

fun main() {
    getDescription(BLUE) //should print blue
    println(BLUE.r)
    println(BLUE.rgb())
}