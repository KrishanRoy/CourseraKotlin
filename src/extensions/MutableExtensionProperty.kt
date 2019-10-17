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
}