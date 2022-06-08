//@file:JvmName("StringFunctions")
//Change the name of the generated class
@file:JvmName("StringFunctions")

package strings

import main
import java.lang.NumberFormatException
import java.lang.StringBuilder

var opCount = 0

const val UNIX_LINE_SEPERATOR = "\n"
//public static final String UNIX_LINE_SEPERATOR = "\n"


fun main(args: Array<String>) {

    val list = listOf("args: ", *args)
    println(list)

    /*
    var name = "Kotlin"
    println(name.lastChar())
    println("Size: ${name.length()}")
    */
    var button: Button = View()
    button.click()
    button.showOff()
    //
    println(">>>>>>")
    val strings: List<String> = listOf("first", "second", "last")
    println(strings.last())
    val value = "Value"
    println(value.lastChar)
    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.max())
    //destructuring declaration
    val (number, name) = 1 to "one"
    println("no: $number name: $name")
    println("12.345-6.A".split(".", "-"))
    //parsePath("Usersyole/kotlin-book/chapter.adoc")

}

/*
fun parsePath(path: String){
    val directory = path.substringBeforeLast("")
    val fullName = path.substringAfterLast("")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}
*/

/*
fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null){
        val (directory, filename,ex)
    }
}
*/

infix fun Any.to(other: Any) = Pair(this, other)


fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")


//extension function
fun String.lastChar(): Char = get(this.length - 1)

fun String.length(): Int = this.length
fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun <T> Collection<T>.joinToString(
    seperator: String = ", ",
    prefix: String = "",
    postFix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postFix)
    return result.toString()
}


fun Collection<String>.join(
    seperator: String = ", ",
    prefix: String = "",
    postFix: String = ""
) = joinToString(seperator, prefix, postFix)


class View : Button() {
    override fun click() = println("View clicked")

}

open class Button() {
    open fun click() = println("Button clicked")
}


val String.lengthOfString: Int
    get() = length
val String.lastChar: Char
    get() = get(length - 1)
//StringBuilder
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }