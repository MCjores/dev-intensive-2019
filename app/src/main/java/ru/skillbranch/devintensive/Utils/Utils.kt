package ru.skillbranch.devintensive.Utils

object Utils {  // Можем обратиться из любой части кода
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        var firstName : String? = null
        var lastName : String? = null

        val parts : List<String>? = fullName?.split(" ")

        if (fullName.equals("") || fullName.equals(" ")){
            return firstName to lastName
        }

         firstName = parts?.getOrNull(0)
         lastName = parts?.getOrNull(1)

//        return  Pair(firstName, lastName)
        return  firstName to lastName
    }

    fun  transliteration(payload: String, devider: String = " ") : String{
        var result : String = ""
            for(char in payload){
                when(char) {
                    'А' -> result+'A'
                    'а' ->result+='a'
                    'Б' ->result+='B'
                    'б' ->result+='b'
                    'В' ->result+='V'
                    'в' ->result+='v'
                    'Г' ->result+="G"
                    'г' ->result+='g'
                    'Д' ->result+='D'
                    'д' ->result+='d'
                    'Е' ->result+='E'
                    'е' ->result+='e'
                    'И' ->result+='I'
                    'и' ->result+='i'
                    'Й' ->result+='Y'
                    'й' ->result+='y'
                    'Л' ->result+= 'L'
                    'л' ->result+= 'l'
                    'М' ->result+= 'M'
                    'м' ->result+= 'm'
                    'О' ->result+= 'O'
                    'о' ->result+= 'o'
                    'Р' ->result+= 'R'
                    'р' ->result+= 'r'
                    'Ч' ->result+= "Ch"
                    'ч' ->result+= "ch"
                    ' ' ->result+= "_"
                }
            }
        return result
        }

//
    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstN = firstName?.get(0)
        val lastN = lastName?.get(0)

    return "${lastN?.toUpperCase()}.${firstN?.toUpperCase()}."
    }
}


//pair - дата класс содержащий в себе 2 значения
// "return  firstName to lastName"  -  эти два значения будут возвращены