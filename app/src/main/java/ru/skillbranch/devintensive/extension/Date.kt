package ru.skillbranch.devintensive.extension

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

// extention функция

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String{
    val  dateFormat = SimpleDateFormat(pattern,Locale("ru"))
    return dateFormat.format(this)
}
fun Date.humanizeDiff(date: Date = Date()): String {

//      var difference = date.time - this.time

//    String.format("%02d:%02d:%02d", difference/ 3600, time / 60 % 60, time % 60)
//    val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//    val start = LocalDateTime.parse(this, format)
//    val end = LocalDateTime.parse(date, format)
//    val difference = ChronoUnit.

    var result =  "$date"
    return result
}


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) :Date{

    var time = this.time

    time += when(units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}