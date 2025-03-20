package myapplication.my.compose.application.my3appcompose.calculator

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.navigation.CustomTopAppBar
import java.util.Calendar

@Composable
fun CalculatorScreen(name : String,navigateToScreen : () -> Unit  ) {

    var dogNameInput by remember { mutableStateOf("") }
    
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    var selectedDate by remember { mutableStateOf("") }

    var dogAge by remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(

        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
        }, year, month, day,

    ).apply {
        // Evento cuando se cancela el diálogo
        setOnDismissListener {
            // Evento adicional al cerrar
            println("El DatePicker se cerró")
            var cantidadDias = DogAgeCalculator.calcularDiferenciaDias(
                selectedDate,
                fechaFin = null,
            )

            if(cantidadDias > 365){
                dogAge= (cantidadDias/365).toString() + " years and "+(cantidadDias%365)+ " days"
            }else{
                dogAge = "less then a year"
            }

        }
    }

    CustomTopAppBar(screenName= "Calculator", navigateToScreen )

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(top =150.dp))
        Text(text = "Dog age Calculator", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)) {
                Text(text = "Dog name", fontSize = 25.sp)

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = dogNameInput,
                    onValueChange = { dogNameInput = it },
                    label = { Text("Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    singleLine = true
                )
            }
        }

        Row(modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Column(modifier = Modifier.fillMaxWidth().padding(15.dp)) {

               Button(
                   modifier = Modifier.fillMaxWidth(),
                   onClick = {
                   println("mostrar fecha")
                   datePickerDialog.show()
               }) {
                   Text(text = "Select Birthday", fontSize = 25.sp)
               }

                Spacer(modifier = Modifier.height(8.dp))
                if(selectedDate.isNotEmpty()){
                    Text(text = "Date: $selectedDate", fontSize = 22.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Name: $dogNameInput ", fontSize = 35.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
                Text(text = dogAge, fontSize = 35.sp, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)

            }
        }

    }

}