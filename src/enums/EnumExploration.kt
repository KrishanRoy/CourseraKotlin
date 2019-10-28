package enums

import enums.Color.*

enum class Color {
    BLUE,
    ORANGE,
    GREEN
}

fun getDescription(color: Color) {
    when (color) {
        BLUE -> println("this is blue")
        ORANGE -> println("This is Orange")
        GREEN -> println("This is Green")
    }
}
fun main(){
    getDescription(BLUE) //should print blue
}