package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extension.TimeUnits
import ru.skillbranch.devintensive.extension.add
import ru.skillbranch.devintensive.extension.format
import ru.skillbranch.devintensive.extension.touserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
//        val user2 = User("2","Jon", "Cean")
//        val user3 = User("3","Jon", "Hegro", null, lastVisit = Date(), isOnLine = true )

//        user.printMe()
//        user2.printMe()
//        user3.printMe()
        println("$user ")
    }

    @Test
    fun test_factory() {
//        val suer = User.makeUser("null")// HOME WORK
//        val suer2= User.makeUser("John Kena")
        val user = User.makeUser("John Celena")
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print("$user \n $user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getuserInfo() = user

        val (id, firstName, lastName) = getuserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    // == сравниваем обхекты === сравниваем ссылки
    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.MINUTE))
        val user3 = user.copy(id = "2", lastVisit = Date().add(2, TimeUnits.HOUR))
        val user4 = user.copy(lastName = "Cena" ,lastVisit = Date().add(-2, TimeUnits.DAY))


        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )

//        if(user === user2){
//            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }else{
//            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }
    }

    @Test
    fun test_data_maping(){
        val user = User.makeUser("Георгий Бильмович")
        val newUser = user.copy(lastVisit = Date().add(-3, TimeUnits.DAY))

        val userView = newUser.touserView()
        println(user)

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Георгий Бильмович")
        val txtMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "text message", type = "text")
        val imgMessage =
            BaseMessage.makeMessage(user, Chat("0"), payload = "image message", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
        }
    }

