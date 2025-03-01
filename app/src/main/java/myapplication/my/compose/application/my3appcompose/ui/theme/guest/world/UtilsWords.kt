package myapplication.my.compose.application.my3appcompose.ui.theme.guest.world

import java.util.Arrays
import java.util.Collections

class UtilsWords {

    companion object {
        fun mixWord(word: String): String {
            val words = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile( {it.isEmpty()  }).toTypedArray())
            Collections.shuffle(words)
            var mixed = ""

            for (i in words){
                mixed +=i
            }
            return  mixed
        }
    }

}