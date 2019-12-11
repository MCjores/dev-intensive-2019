package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.Utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = null,
    var isOnLine: Boolean = false

// то что выше - первичный конструктор
) {
    //тело класса
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "Josh", "Doe")

    init {

        println(
            "It's alive!!! \n " +
                    "${if (lastName === "Doe") "His name id $firstName $id"
                    else "And His name is  $firstName $lastName"} \n"
        )
    }

       companion object Factory{
           private var lastId:Int = -1

           fun makeUser(fullName: String?) : User{
               lastId++

               val parts : List<String>? = fullName?.split(" ")

               var (firstName, lastName) = Utils.parseFullName(fullName)

               return User(id = "$lastId", firstName = firstName , lastName = lastName)
           }
       }

}
