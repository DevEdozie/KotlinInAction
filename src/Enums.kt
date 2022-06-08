import javafx.scene.paint.Color.INDIGO
import javafx.scene.paint.Color.VIOLET
import strings.joinToString
//import strings.middleChar
//import strings.middleChar
import strings.middleChar as md
import java.awt.Color.*
import java.io.BufferedReader
import java.io.StringReader
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.util.*



enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 * g) * 256 + b
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "Warmth"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) ->
            Color.ORANGE


        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c2 == Color.YELLOW && c1 == Color.BLUE) ->
            Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c2 == Color.BLUE && c1 == Color.VIOLET) ->
            Color.INDIGO
        else -> throw Exception(
            "Dirty color)"
        )
    }

fun main(args: Array<String>) {
    /*
    var color = Color.BLUE
    val color2 = Color.VIOLET
    println(Color.BLUE.rgb())
    println(getMnemonic(color))
    println(getWarmth(color))
    println(mixOptimized(color, color2))
    */
    //println(evalWithLogging(Sum(Sum(Num(1),Num(2)),Num(4))))
    /*
    for(i in 100 downTo 1 step 2){
        println(fizzBuzz(i))
    }
    */
    /*
    //Create a TreeMap
    val binaryReps = TreeMap<Char, String>()

    //Loop through the characters from A..F
    for(c in 'A'..'F'){
        //Convert ASCII code to binary
        val binary = Integer.toBinaryString(c.toInt())
        //Store the value in a map using the Letter as the key
        binaryReps[c] = binary
    }
    //Iterate over the map using
    //letter as the key and binary as the value
    for((letter,binary) in binaryReps){
        println("$letter = $binary")
    }
    */
    /*
    val list = arrayListOf("10","11","1001")
    for((index,element) in list.withIndex()){
        println("$index: $element")
    }
    */
    // println(isLetter('q'))
    // println(isNotDigit('1'))
    /*
    var age = 20
    when{
        age == 20 ->
            println("Michael\n......")
        age == 18 ->
            println("Chisom\n")
        else ->
            println("I don't know o")
    }
    age = 18
    when (age){
         20 -> "Michael\n......"
         18 -> "Chisom\n"
        else -> "I don't know o"
    }
    */
    //println(recognize('8'))
    //println("Kotlin" in "Java".."Scala")
    // println("Kotlin" in setOf("Java","Scala"))
    //val reader = BufferedReader(StringReader("not a number"))
    //println(readNumber(reader))
    //joinToString()
    /*
    val c = "Kot6lin"
    val lc = c.lastChar
    println(c.lastChar)
    println(c.lengthOfString)
    println(">>>>>>")
    //
    val sb = StringBuilder("Kotlin")
    sb.lastChar = 'r'
    println(sb)
    //val list = hashSetOf("1","2","3")
    //println(list.join())
    */
    //val list = listOf(1,2,3)
    //println(joinToString(list,seperator = "#"))
    println("Hello".md())

}

@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    seperator: String = "@",
    prefix: String = "{",
    postfix: String = "}"
): String{
    val result = StringBuilder(prefix)
    for((index,element) in collection.withIndex()){
        if(index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}


fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
        println("first line is run")
    } catch (e: NumberFormatException) {
        println("second line is run")
        null
    }
    println(number)
    println("final line is run")

}


fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}


fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'


fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}


interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
/*
fun eval(e: Expr): Int{
    if(e is Num){
        val n = e as Num
        return n.value
    }
    if(e is Sum){
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}
*/

/*
fun eval(e: Expr):Int =
        if(e is Num){
            e.value
        }else if (e is Sum){
            eval(e.right) + eval(e.left)
        }else {
            throw IllegalArgumentException("Unknown expression")
        }
        */

fun eval(e: Expr): Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            eval(e.right) + eval(e.left)
        else ->
            throw IllegalArgumentException("Unknown Expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else ->
            throw IllegalArgumentException("Unknown Expression")
    }

