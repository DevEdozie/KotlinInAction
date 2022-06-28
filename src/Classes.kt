import java.beans.PersistenceDelegate
import java.lang.management.ManagementFactory

/*
class AUser(val nickname: String, val isSubscribed: Boolean = true) {
    val name = nickname
}

class BUser constructor(_nickname: String, val isSubscribed: Boolean = true) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

class CUser(_nickname: String, val isSubscribed: Boolean = true) {
    val nickname = _nickname
}

class DUser(var nickname: String, var isSubscribed: Boolean) {
}


open class User(val nickname: String){}

class TwitterUser(nickname: String) : User(nickname){}

 class Secretive private constructor(){}




fun main(args: Array<String>) {
    val alice = AUser("Alice")
    println(alice.isSubscribed)
    println(alice.name)
    //
    val bob = BUser("Bob", false)
    println(bob.isSubscribed)
    //
    val carol = CUser("Carol", isSubscribed = false)
    println(carol.isSubscribed)
    //
    val dave = DUser("Dave", false)
    dave.nickname = "DAVE"
    dave.isSubscribed = true
    println("Name: ${dave.nickname} SUB: ${dave.isSubscribed}")
}

open class View{
    //no primary constructor declared
    //secondary constructors
    constructor(ctx: Context){
        //some code
    }
    constructor(ctx: Context, attr: AttributeSet){
        //some code
    }
}

class MyButton : View {
    constructor(ctx : Context) : super(ctx){
        //code
    }
    constructor(ctx: Context,  attr: AttributeSet):
            super(ctx, attr){
        //code
    }
}
 */


class User private constructor(val nickname: String) {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val subcribingUser = User.newSubscribingUser("bob@gmail.com")
            val facebookUser = User.newFacebookUser(1)
            println(subcribingUser.nickname)
            println(facebookUser.nickname)

        }


        fun newSubscribingUser(email: String) =
            User(email.substringBefore("@"))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))


        fun getFacebookName(accountId: Int): String {
            var faceBookUsers = arrayOf("Michael", "Chiedozie", "Goat")
            var user = faceBookUsers[accountId]
            return user
        }

    }

}

interface JSONFactory<T>{
    fun fromJSON(jsonText: String):T
}

class Person(val name:String){
    companion object Loader:JSONFactory<Person>{
        @JvmStatic
        fun main(args: Array<String>) {
            var person1 = Person.Loader.fromJSON("{name: 'Dmitry'}")
            println(person1.name)
            var person2 = Person.fromJSON("{name: 'Brent'}")
            println(person2.name)
        }


        override fun fromJSON(jsonText:String):Person = Person(jsonText)
    }
}

/*
val nickname: String

constructor(email:String){
    nickname = email.substringBefore("@")
}

constructor(facebookAccountId:Int){
    nickname = getFacebookName(facebookAccountId)
}


fun getFacebookName(accountId: Int): String {
    var faceBookUsers = arrayOf("Michael", "Chisom", "Goat")
    var user = faceBookUsers[accountId]
    return user
}
*/


/*
// overrides the property in the primary constructor
class PrivateUser(override val nickname: String) : User

//overrides the property,  uses a custom getter
class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@")
}


//property initializer
class FaceBookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId)



}

class User(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent()
            )
            field = value
        }

    override fun toString(): String {
        return "User to String"
    }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

data class Client(val name: String, val postalCode: Int) {
    /*
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    override fun toString(): String = "Client(name=$name,postalCode=$postalCode"
    */
}

fun main(args: Array<String>) {
/*
val user = User("Michael")
val client1 = Client("Alice",342562)
println(client1)
println(user)
*/
/*
val processed = hashSetOf(Client("Alice",342562))
println(processed.contains(Client("Alice",342562)))

val client1 = Client("Client",1)
val client2 = Client("Client",1)
val equal = client1 == client2
println(equal)
println(client1)
println(client1.copy(postalCode = 2))
println(client1)
println(equal)
*/

/*
val lengthCounter = LengthCounter()
lengthCounter.addWord("Hi!")
println(lengthCounter.counter)
*/

/*
val user = User("Alice")
user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
println(user.address)

println(PrivateUser("test@kotlinlang.org").nickname)
println(SubscribingUser("test@kotlinlang.org").nickname)
println(FaceBookUser(2).nickname)

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) :
    MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        //increment by one whenever this method is called
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        //add the size of the collection to objectsAdded
        //objectsAdded = objectsAdded + c.size
        objectsAdded += c.size
        return innerSet.addAll(c)
    }

}


*/