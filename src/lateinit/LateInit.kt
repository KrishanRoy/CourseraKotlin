package lateinit

lateinit var myData: MyData //it cannot be val as it has to be initialized later so it cannot have final properties under the hood

class MyData {

}
