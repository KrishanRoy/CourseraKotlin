import com.sun.org.apache.xpath.internal.operations.Bool

fun main() {
    val list1 = listOf(1, 2, 4)
    list1.allNonZero()
    list1.allNonZero1()
    list1.allNonZero2()

    !list1.containsZero()
    !list1.containsZero1()
    !list1.containsZero2()
    val rectangle = Rectangle(2, 3)
    println(rectangle.isSquare) // should print false
    println("$foo1$foo1$foo2$foo2") // should print "calculating the answer 3 times"
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi")
    println(lengthCounter.counter) //getter is called under the hood and it should print 2 (length of "Hi" String)
}

fun List<Int>.allNonZero() = all { it != 0 }
fun List<Int>.allNonZero1() = none { it == 0 }
fun List<Int>.allNonZero2() = !any { it == 0 }

fun List<Int>.containsZero() = !all { it != 0 }
fun List<Int>.containsZero1() = !none { it == 0 }
fun List<Int>.containsZero2() = any { it == 0 }

class Rectangle(private val height: Int, private val width: Int) {
    val isSquare: Boolean //this is just a method that checks if the height and width of a rectangle object are same
        get() {
            return height == width
        }
}

val foo1 = run {
    println("calculating the answer..")
    42
}
val foo2: Int
    get() {
        println("calculating the answer..")
        return 42
    }
class LengthCounter{
    var counter: Int = 0
    fun addWord(word: String){
        counter += word.length
    }
}

