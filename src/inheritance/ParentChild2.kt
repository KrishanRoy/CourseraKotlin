package inheritance

open class Parent1 {
    open val foo = 1

    init {
        println(foo)
    }
}

class Child1 : Parent1() {
    override val foo = 2
}

/**
 * Kotlin for Java Developers: Week 4: Constructors, Inheritance syntax
 * ----------------------------------------------------------------------
 * The right answer is surprisingly zero.
 * Reason::
 * In Java, it's impossible to override fields and under the hood in
 * Kotlin is the same. When you override a property, in fact, you
 * override a getter not a field. For instance, you can override a
 * property that doesn't have a field with a property that has a field.
 * That's totally legal. However, when both a property from a superclass
 * and an overridden property in a subclass have fields, that might lead
 * to unexpected results. Let's see what bytecode is generated for the
 * Kotlin class in our example. As usual, we'll look at the corresponding
 * Java code instead for simplicity. Note two things here. First, the foo
 * get to is trivial, so a field and a getter correspond to the full
 * property. Then because the property is open and can be overridden
 * in a subclass, its usage inside the class is compiled to a getter
 * code not a field code. Now, the generated code for the child class.
 * Note that the overridden property in the parent class is also
 * compiled to a field and a getter, and now it's another field.
 * What happens when you create an instance of the child class? At
 * first at the parent constructor is called, the parent constructor
 * initializes the first fulfilled with one. But inside the init section,
 * an overridden getter is called which calls get foo from the child class.
 * Because the field in the child class is not yet initialized, zero is returned.
 *
 * That's why zero is printed here.
 */
fun main() {
    Child1() //prints 0 !!!
}