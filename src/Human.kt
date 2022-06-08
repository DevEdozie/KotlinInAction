


class Human(val name: String, val age: Int, val gender: String)



fun printDetails(human: Human){
    fun Human.setDependency(){
        var dependency: String = ""
        val isAdult = age >= 18 || age < 40
        val isMinor = age < 18
        val isSenior = age >= 40
        if(isAdult){
            dependency = "Adult"
        }else if(isMinor){
            dependency = "Minor"
        }else if(isSenior){
            dependency = "Senior"
        }
        println("Dependency:$dependency")
    }
    println("Name:${human.name} Age:${human.age} Gender:${human.gender}")
    human.setDependency()
    human.printNames(human.name)
}

fun Human.printNames(name: String){
    val firstName = name.substringBeforeLast(" ")
    val lastName = name.substringAfterLast(" ")
    print("FirstName: $firstName \nLastName: $lastName")
}

fun main(args: Array<String>) {
    printDetails(Human("Michael Ojiakor",20,"Male"))
}