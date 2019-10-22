package lateinit

/**
*   If we do not initialize a lateinit property, a specific error is
    thrown -->UninitializedPropertyAccessException is thrown
*   they cannot be nullable, so a lateinit property cannot be null.
    the reason we have lateinit is that we do not want to deal with null properties.
*   it cannot be val as it has to be initialized later so it cannot have final properties under the hood
 *
 *  Cannot be primitive type
 */
lateinit var myData: MyData
class MyData {

}
class MyClass{
    lateinit var lateInitVar: String
    fun initializationLogic(){
        println(this::lateInitVar.isInitialized) //prints false
        lateInitVar = "some value to initialize"
        println(this::lateInitVar.isInitialized) //prints true
    }
}
fun main(){
    MyClass().initializationLogic() //false
                                    //true
}
class Person(name: String){  //-->class Person(val name: String)
    val name: String
init{
    this.name = name
}
}
