import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String, val language: String )


fun saveUser(user: User){

    fun User.validateBeforeSave() {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName"
                )
            }
        }
        validate(name,"Name")
        validate(address,"Address")
        validate(language,"Language")
        //Save user to database
        println("Successfully Saved")
        println("id: $id Name: $name address: $address Language: $language")
    }
    user.validateBeforeSave()
}


fun main(args: Array<String>) {
    saveUser(User(1,"Kingsley","faraday@gmail.com","React"))
    saveUser(User(2,"Michael","nicholausmichael51@gmail.com","Kotlin"))
    //will throw an exception
    saveUser(User(3,"Goat","mIKE",""))
}


/*
    fun saveUser(user: User){
        if(user.name.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name")
            }

        if(user.address.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty address"
            )
        }
        //Save user to the database
    }



fun saveUser(user: User) {
    //Declare a local function to validate any field
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save ${user.id}: empty $fieldName"
            )
        }
    }
    //Call the local function to validate the following fields
    validate(user.name, "Name")
    validate( user.address, "Address")
    //println("${user.name} with user id: ${user.id} and Name: ${user.address} has been saved")
    //Save user to the database
}
    */


