


interface Clickable {
    fun click() = println("Click")
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}


class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton: Clickable{
    //final by default, can't override in a subclass
    fun disable(){}
    //can override in a subclass
    open fun animate(){}
    //overrides an open function and is open as well
    override fun click(){}
}

abstract class Animated{
    //must be implemented in subclasses
    abstract fun animate()
    /*
    Kotlin allows for non-abstract
    functions in abstract classes.
    Also, they are open by default but can
    still be declared as open
     */
    open fun stopAnimating(){
        //Body
    }
    //Still open
    fun animateTwice(){
        //Body
    }
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()

}
/*
class Animal(var name: String, var kingdom: String, var report: String): Feline,Canine

fun getKingdom(animal: Animal) {
    println("Running")
    fun validate(){
        if(animal.isCanine(animal.kingdom)){
            println("Canine")
            animal.report = ("$animal.name is of the Dog family")
        }
        if(animal.isFeline(animal.kingdom)){
            println("Feline")
            animal.report = ("$animal.name is of the Cat family")
        }
    }
    println(animal.report)
}

interface Feline{
    fun isFeline(kingdom: String): Boolean{
        var feline = false
        if(kingdom == "Feline"){
            feline = true
        }else{
            println("Not Feline")
        }
        return feline
    }
}


interface Canine{
    fun isCanine(kingdom: String): Boolean{
        var canine = false
        if(kingdom == "Canine"){
            canine = true
        }else{
            println("Not Canine")
        }
        return canine
    }
}

*/






