package myapplication.my.compose.application.my3appcompose.calculator

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Calendar
import java.util.Date

class DogAgeCalculator {

    companion object {

        fun calcularDiferenciaDias(
            fechaInicio: String,
            fechaFin: String?,
        ): Long {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            try {
                val startDate = dateFormat.parse(fechaInicio)


                var endDate = today()

                if(fechaFin != null){
                    endDate = dateFormat.parse(fechaFin)
                }

                if (startDate != null && endDate != null) {
                    val diferencia = endDate.time - startDate.time
                    return diferencia / (1000 * 60 * 60 * 24)  // Convertimos de milisegundos a días
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return 0
        }

        fun today():Date {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1 // Los meses empiezan en 0, por eso le sumamos 1
            val year = calendar.get(Calendar.YEAR)

            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            return dateFormat.parse("$day/$month/$year") ;
        }
    }


}