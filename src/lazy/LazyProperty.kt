package lazy

/**
 * lazy { } takes a lambda inside the curly braces
 * and computes a value that will be stored in the property
 */
val lazyValue: String by lazy {
    println("Computed")
    "Hello!"
}
val lazyValue1: String by lazy {
     "lazyValue1 " + "kkks".length
}
fun main() {
    println(lazyValue)
    println(lazyValue) //computed
                        //Hello
                        //Hello
    println(lazyValue1)
}