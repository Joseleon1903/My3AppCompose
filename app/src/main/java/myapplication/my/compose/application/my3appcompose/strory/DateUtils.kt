package myapplication.my.compose.application.my3appcompose.strory

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateUtils {

    companion object {

        fun getFormattedDateTime(): String {
            val currentDateTime = Date()
            val formatter = SimpleDateFormat("dd/MM/yyyy, hh:mm a", Locale.getDefault())
            return formatter.format(currentDateTime)
        }
    }

}