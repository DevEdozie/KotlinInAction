import java.util.jar.Attributes
import javax.naming.Context
import javax.swing.text.AttributeSet

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
    constructor(ctx: Context) : super(ctx){
        //some code
    }
    constructor(ctx: Context,attr: AttributeSet): super(ctx,attr){
        //some code
    }
}