package myapplication.my.compose.application.my3appcompose.world

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

        fun increaseString(current: String ): String {
            var actualNumber = current.toInt();
            actualNumber++
            return actualNumber.toString()
        }

        fun decreaseString(current: String ): String {
            var actualNumber = current.toInt();
            actualNumber--

            if(actualNumber == 0){
                println("Game Over")
                throw Exception()
            }
            return actualNumber.toString()
        }

    }

}