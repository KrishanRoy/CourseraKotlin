package inheritance

open class Parent(private val name: String) {
    open fun something() = println("I am a parent")
}

class Child(name: String) : Parent(name) {
    override fun something() = println("I am a child")
}

fun main() {
    val parent1 = Parent("Parent")
    parent1.something() //should print "I am Parent" due to compile time Polymorphism
    val parent = Child("child")
    parent.something()//should print "I am child" which is called runtime polymorphism
}