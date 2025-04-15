package myapplication.my.compose.application.my3appcompose.world

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.R
import myapplication.my.compose.application.my3appcompose.navigation.CustomTopAppBar
import java.util.Random

@Composable
fun GuestWorldScreen (guestList : Array<String>,  navigateToScreen : () -> Unit){

    val context = LocalContext.current
    val isVisible = remember { mutableStateOf(false) }

    var textInput by remember { mutableStateOf("") }
    var showLabel by remember { mutableStateOf("") }

    var winCounter by remember { mutableStateOf("0") }
    var lifeCounter by remember { mutableStateOf("5") }


    var day : String? = null;
    var guest:String = "";
    if(day.isNullOrBlank()){
        day =  guestList[Random().nextInt(guestList.size)]
        guest = UtilsWords.mixWord(day)
    }

    var guestLabel by remember { mutableStateOf(guest) }




    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)) {

        CustomTopAppBar("Guest Word",navigateToScreen )

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
            text = guestLabel,
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


        // vidas y fallos jiego status
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center, // Centrar en la pantalla
            horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
        ) {

            Row(  modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){

                // trophy Button
                Button(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier.height(200.dp).width(150.dp)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra la columna horizontalmente
                        verticalArrangement = Arrangement.Center, // Centra los elementos dentro de la columna
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Imagen en la parte superior
                        Image(
                            painter = painterResource(id = R.drawable.trophy), // Aquí debes usar tu imagen
                            contentDescription = "Imagen dentro del botón",
                            modifier = Modifier.size(40.dp) // Tamaño de la imagen
                        )

                        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la imagen y el texto

                        // Texto en la parte inferior
                        Text(
                            text = winCounter,
                            color = Color.White, // Color del texto
                            fontSize = 24.sp
                        )
                    }
                }

                // lifeButton
                Button(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier.height(200.dp).width(150.dp)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra la columna horizontalmente
                        verticalArrangement = Arrangement.Center, // Centra los elementos dentro de la columna
                    ) {
                        // Imagen en la parte superior
                        Image(
                            painter = painterResource(id = R.drawable.life_insurance), // Aquí debes usar tu imagen
                            contentDescription = "Imagen dentro del botón",
                            modifier = Modifier.size(40.dp) // Tamaño de la imagen
                        )

                        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre la imagen y el texto

                        // Texto en la parte inferior
                        Text(
                            text = lifeCounter,
                            color = Color.White, // Color del texto
                            fontSize = 24.sp
                        )
                    }
                }

            }
        }




        //linear de botones 3


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // Centrar en la pantalla
            horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red),
                horizontalArrangement = Arrangement.Center // Espaciado uniforme
            ) {
                Button(
                    onClick = {
                        println("Entering in Show button")
                        showLabel =day!!
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
                            winCounter = UtilsWords.increaseString(winCounter)
                        }else{
                            try {
                                lifeCounter = UtilsWords.decreaseString(lifeCounter)
                                Toast.makeText(context, "Try Again!!", Toast.LENGTH_SHORT).show()
                                textInput = ""
                            }catch (ex: Exception){
                                Toast.makeText(context, "You Lose!!!", Toast.LENGTH_SHORT).show()
                                isVisible.value = false
                                textInput = ""
                                winCounter = "0"
                                lifeCounter = "5"
                            }
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
                        day = guestList[Random().nextInt(guestList.size)]
                        guest = UtilsWords.mixWord(day!!)
                        guestLabel = guest
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