package ru.skillbranch.devintensive.extension

import ru.skillbranch.devintensive.Utils.Utils
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import java.time.LocalDateTime
import java.time.chrono.ChronoLocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import java.util.*

fun User.touserView() : UserView {

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status =  if (lastVisit == null) "Еще не разу не " +
            "был" else if(isOnLine) "Online" else "последнйи раз был ${lastVisit!!.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickname ,
        initials = initials ,
        status = status )
}


//@UseExperimental(ExperimentalStdlibApi::class)
//fun String.truncate(count : Int = 16) :String{
//    var result = ""
//    val str = this.toCharArray(0,count)
//
//    for ((index, char) in str.withIndex()) {
//        if (index == count-1 && char.equals(' ')) {
//            result += "..."
//            return result
//        }else
//        result += char
//
//    }
//    result += "..."
//
//    return result
//}


