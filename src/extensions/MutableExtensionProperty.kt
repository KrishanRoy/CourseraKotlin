package extensions

import java.lang.StringBuilder

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(){
    val language = StringBuilder("Kotlin?")
    println(language.lastChar) //prints ?
    language.lastChar = '@' //sets the last char @
    println(language.lastChar) //prints @
    println("hii.jpg".checkImageExtension())//prints true
    println("hii.png".checkImageExtension())//prints true
    println("hii.jpeg".checkImageExtension()) //prints true
    println("hii.jpeeg".checkImageExtension()) //prints false
    println(null.checkImageExtension()) //prints false when null

}
fun String?.checkImageExtension(): Boolean =
    with(this) {
        this?.endsWith(".jpeg") ?: false
                || this?.endsWith(".png") ?: false
                || this?.endsWith(".jpg") ?: false
    }
