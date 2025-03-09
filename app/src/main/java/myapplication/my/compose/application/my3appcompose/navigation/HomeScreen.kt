package myapplication.my.compose.application.my3appcompose.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen( navigateToScreen : (String) -> Unit) {

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "HOME SCREEN", fontSize = 25.sp)

        Spacer(modifier = Modifier.weight(1f))

        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center, // Centrar en la pantalla
            horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente
        ) {

            Button(
                onClick = { navigateToScreen(GuestWorld.toString()) },
                modifier = Modifier.height(100.dp).fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Navigate to Guest Game")
            }

            Button(
                onClick = { navigateToScreen(Calculator.toString()) },
                modifier = Modifier.height(100.dp).fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Navigate to Calculator")
            }

            Button(
                onClick = { navigateToScreen(LongStory.toString()) },
                modifier = Modifier.height(100.dp).fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Navigate to Long Story")
            }

        }
        Spacer(modifier = Modifier.weight(1f))

    }


}

@Preview(showBackground = true)
@Composable
fun AppMainView(){

    HomeScreen { println("press buton") }

}