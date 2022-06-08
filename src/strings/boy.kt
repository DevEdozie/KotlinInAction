//@file:JvmName("BoyStuff")
package strings

import java.lang.StringBuilder

const val AGE = 20
val name = "Boy"


fun sayMyName(name: String) {
    println("Hello!, my name is $name")
}


//Extension Property
val String.firstChar: Char
    get() = get(0)
var StringBuilder.firstChar: Char
    get() = get(0)
    set(value: Char) {
        setCharAt(0, value)
    }


//Extension Function
fun String.middleChar(): String {
    var evenResult = StringBuilder(2)
    var middleChar: Char
    var evenMiddleChar: Char
    //removed this
    val lengthOfString = length
    var remainder = lengthOfString % 2
    var meanOfString = lengthOfString / 2
    var isOdd = false
    var isEven = false
    if (remainder > 0) isOdd = true
    else if (remainder == 0) isEven = true
    if (isEven) {
        //removed this
        middleChar = get(meanOfString)
        //removed this
        evenMiddleChar = get(meanOfString - 1)
        evenResult.append(evenMiddleChar)
        evenResult.append(middleChar)
        return evenResult.toString()
    } else if (isOdd) {
        //removed this
        middleChar = get(meanOfString)
        return middleChar.toString()
    }
    return "Never to run"
    //println("Odd: $isOdd \n Even: $isEven")
    //if(result )
}

fun String.append(value: String): String {
    var valid = true
    var currentValue = get(0)
    var index = 1
    var result = StringBuilder(currentValue.toString())
    while (valid) {
        if (index == length) break
        currentValue = get(index)
        result.append(currentValue)
        index++
    }
    result.append(" ")
    result.append(value)
    return result.toString()
}


fun fullName(userName: String){
    val fullName = userName.substringBeforeLast("/")
    val firstName = fullName.substringBeforeLast(" ")
    val lastName =  fullName.substringAfterLast(" ")
    println("FullName: $fullName\nFirstName: $firstName\nLastName: $lastName")
}

/*
fun parsePath(path: String){
    val directory = path.substringBeforeLast("/")
    println("Directory: $directory")
    val fullName = path.substringAfterLast("/")
    println("FullName: $fullName")

    val fileName = fullName.substringBeforeLast(".")
    println("FileName: $fileName")
    val extension = path.substringAfterLast(".")
    println("Extension: $extension")
    println("Dir: $directory,  name: $fileName, ext: $extension")
}
*/

fun parsePath(path: String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun userFullName(value: String){
    val regex = """(.+)//(.+)/(.+)""".toRegex()
    val matchResult = regex.matchEntire(value)
    if(matchResult != null){
        val (firstName, lastname, age) = matchResult.destructured
        println("FirstName: $firstName LastName: $lastname Age: $age")
    }
}

fun main(args: Array<String>) {
    val kotlinLogo =  """|//
                        .|//
                        .|/\"""
    println(kotlinLogo.trimMargin("."))

    val windowsStylePath = """C:\Users\yole\kotlin-book"""
    println(windowsStylePath)
    val secondOption = "C:\\Users\\yole\\kotlin-book"
    println(secondOption)
    val price = """${'$'}99.9$secondOption"""
    println(price)

    //fullName("Michael Ojiakor/")
    //parsePath("Usersyole/kotlin-book/chapter.adoc")
    //userFullName("Michael//Ojiakor/20")
    // val (number,name) = "One" to "1"
   // println("No: $number Name: $name")
    //println("Michael".split("m","a","e"))
    //println("12.345-6.A".split(".","-"))
    //println("Michael/".split("/"))
    /*
    var name = "Boy"
    println(name.firstChar())
    var num = 4
    var remainder = 4 % 2
    var isOdd = false
    var isEven = false
    if(remainder > 0 ) isOdd = true
    else if(remainder == 0) isEven = true
    println("Odd: $isOdd \n Even: $isEven")
*/
    //val human: Human = Boy()
    //human.dance()
    //println("Girrafe".firstChar)
    //val sb = StringBuilder("Fichael")
    //sb.firstChar = 'M'
    //println(sb)
}


open class Human {
    open fun talk() = println("I am a Human")
}

class Boy : Human() {
    override fun talk() = println("I am a Boy")
    fun dance() = println("Class boy is dancing")
}
fun Human.dance() = println("Human is dancing")
fun Boy.dance() = println("Boy is dancing")





