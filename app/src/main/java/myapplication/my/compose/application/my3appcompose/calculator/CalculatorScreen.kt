package myapplication.my.compose.application.my3appcompose.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.navigation.CustomTopAppBar

@Composable
fun CalculatorScreen(name : String,navigateToScreen : () -> Unit  ) {

    CustomTopAppBar(screenName= "Calculator", navigateToScreen )

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Calculator $name", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))


    }

}

@Preview(showBackground = true)
@Composable
fun AppMainView(){

    CalculatorScreen("example"){ println("gogog")}

}