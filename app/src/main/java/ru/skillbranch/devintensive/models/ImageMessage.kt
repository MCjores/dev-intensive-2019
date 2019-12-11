package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extension.humanizeDiff
import java.util.*

class ImageMessage(
    id :String,
    from :User?,
    chat :Chat,
    isComming : Boolean = false, //входящее исходящее
    date: Date = Date(),
    var image:String
) :BaseMessage ( id, from, chat, isComming, date){
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
                "${if(isComming) "получил" else "отправил"}  изображение \"$image\" ${date.humanizeDiff()}"
    }
