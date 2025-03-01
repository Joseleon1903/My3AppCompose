package myapplication.my.compose.application.my3appcompose

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.ui.theme.My3AppComposeTheme
import myapplication.my.compose.application.my3appcompose.ui.theme.guest.world.UtilsWords
import java.util.Arrays
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppMainView()
        }
    }
}

@Composable
fun AppNameTitle(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = "Guest the World!!",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppMainView(){

    val context = LocalContext.current
    val isVisible = remember { mutableStateOf(false) }

    var Days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    var day :String= ""
    var random :Random = Random()


    var textInput by remember { mutableStateOf("") }
    var question by remember { mutableStateOf("") }
    var showLabel by remember { mutableStateOf("") }

    day = Days[random.nextInt(Days.size)]
    question = UtilsWords.mixWord(day)



    My3AppComposeTheme {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)) {

            // correct answer label
            Spacer(modifier = Modifier.height(50.dp))

            // Animación de entrada y salida del texto
            AnimatedVisibility(
                visible = isVisible.value,
                enter = fadeIn() + expandVertically(), // Animación de entrada (deslizar y desvanecer)
                exit = fadeOut() + shrinkVertically() // Animación de salida (deslizar y desvanecer)
            ) {
                Text(
                    text = "Correct Answer",
                    fontSize = 32.sp,  // Tamaño del texto
                    color = Color.Black,  // Color del texto
                    textAlign = TextAlign.Center,

                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green) // Color de fondo
                        .padding(15.dp)
                    // Añadir un poco de padding
                )
            }

            if(isVisible.value){
                // text view Component
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = showLabel,
                    fontSize = 24.sp,  // Tamaño del texto
                    color = Color.White,  // Color del texto
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black) // Color de fondo
                        .padding(15.dp) // Añadir un poco de padding
                )
            }


            //random text
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = question,
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(12.dp)) // Fondo y esquinas redondeadas
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Padding interno
            )

            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = textInput,
                onValueChange = { textInput = it },
                label = { Text("Ingrese texto") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(100.dp))
            //linear de botones 3


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, // Centrar en la pantalla
                horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxWidth()
                        .background(Color.Red),
                    horizontalArrangement = Arrangement.Center // Espaciado uniforme
                ) {
                    Button(
                        onClick = {
                                    println("Entering in Show button")
                                    showLabel = day
                                    isVisible.value = true
                                  },
                        modifier = Modifier
                            .weight(2f)
                            .border(2.dp, Color.Black),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RectangleShape
                    ) {
                        Text("Show")

                    }
                    Button(
                        onClick = {
                            println("Entering in check button")
                            if (textInput.equals(day, ignoreCase = true)){
                                Toast.makeText(context, "You got it!!", Toast.LENGTH_SHORT).show()
                                isVisible.value = true
                            }else{
                                Toast.makeText(context, "Try Again!!", Toast.LENGTH_SHORT).show()
                            } },
                        modifier = Modifier
                            .weight(2f)
                            .border(2.dp, Color.Black),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RectangleShape
                    ) {
                        Text("Check")
                    }
                    Button(
                        onClick = {
                            println("Entering in Next button")
                            day = Days[random.nextInt(Days.size)]
                            question = UtilsWords.mixWord(day)
                            isVisible.value = false
                            textInput = ""
                        },
                        modifier = Modifier
                            .weight(2f)
                            .border(2.dp, Color.Black),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RectangleShape,
                    ) {
                        Text("Next")
                    }
                }
            }

        }

    }

}



@Composable
fun GreetingPreview() {
    My3AppComposeTheme {

        Column(modifier = Modifier.fillMaxWidth()) {

            AppNameTitle()

        }
    }
}