import java.io.File

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for ((index, person) in allEmployees.withIndex()) {
            println(person.name)
        }
    }
}

 object Animal{
     var name:String? = null
     var age:Int? = null
     var gender:String? = null
     var type:String? = null

     fun printDetails(){
         println("Name:${name}\nAge:${age}\nGender:${gender}\nType:${type}")
     }
 }

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)


    }
}

fun main(args: Array<String>) {
    /*
    Payroll.allEmployees.add(Person("Michael"))
    Payroll.allEmployees.add(Person("Judith"))
    Payroll.calculateSalary()
    CaseInsensitiveFileComparator.compare(File("User"), File("user"))
    val files = listOf(File("Z"), File("a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    val persons = listOf(Person("Bob"),Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
    */
    var name ="Bruno"
    var age = 20
    var gender = "Male"
    var type = "Rot"
    Animal.name = name
    Animal.age = age
    Animal.gender = gender
    Animal.type = type
    Animal.printDetails()
}