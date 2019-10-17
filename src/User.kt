interface User {
    val nickName: String
}

/**
 * both of the following classes implements User interface
 * so they have to implement the field nickName of type String
 * FaceBookUser.nickname will be calculated only once as it is
 * saved inside a field
 * whereas the SubscribingUser.nickname will be calculated on each access
 * since the property has a custom getter and does not have the corresponding field
 */
class FaceBookUser(private val accountId: Int) : User {
    override val nickName: String = getFaceBookName(accountId)

    private fun getFaceBookName(accountId: Int): String = accountId.toString()
}

class SubscribingUser(val email: String) : User {
    override val nickName: String
        get() = email.substringBefore('@')
}

fun main() {
    val user: FaceBookUser = FaceBookUser(123)
    println("${user.nickName} ${user.nickName} ${user.nickName}") //should print 123 123 123
    val user1: SubscribingUser = SubscribingUser("krishan@gmail.com")
    println(user1.nickName)  // should print krishan
}
