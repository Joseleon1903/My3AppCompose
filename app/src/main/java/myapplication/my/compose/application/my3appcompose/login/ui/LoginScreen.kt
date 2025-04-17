package myapplication.my.compose.application.my3appcompose.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel : LoginViewModel){

    val email : String by viewModel.email.observeAsState( initial = "")
    val password : String by viewModel.password.observeAsState( initial = "")

    val loginEnable : Boolean by viewModel.loginEnable.observeAsState( initial = false)

    var passwordVisible by remember { mutableStateOf(false) }

    val isLoading : Boolean by viewModel.isLoading.observeAsState( initial = false)

    val scope = rememberCoroutineScope()

    if(isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
    else{

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo), // Cambia esto con tu recurso real
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            OutlinedTextField(
                value = email,
                onValueChange = {viewModel.onValueLoginChange(it, password) },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onValueLoginChange(email, it)},
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            // Forgot Password
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = "Forgot Password?",
                    color = Color(0xFFFF9800), // Color naranja suave
                    fontSize = 12.sp,
                    modifier = Modifier.clickable { /* Acción de recuperar contraseña */ }
                )
            }

            // Botón Log In
            Button(
                onClick = { scope.launch {  viewModel.onLoginSelected() } },
                enabled = loginEnable,
                colors = ButtonDefaults.buttonColors(containerColor = Color(79,117,32,255)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Log In", color = Color.White)
            }

            Spacer(modifier = Modifier.height(8.dp))


        }


//        Text("OR", color = Color.Gray)
//
//        Spacer(modifier = Modifier.height(8.dp))

        // Botón Facebook
//        OutlinedButton(
//            onClick = { /* Acción de Facebook Login */ },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.ic_facebook), // Recurso del ícono
//                contentDescription = "Facebook",
//                tint = Color(0xFF1877F2)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("Continue as Aris", color = Color(0xFF1877F2))
//        }
    }

}


@Preview(showBackground = true)
@Composable
fun AppLoginView(){

    LoginScreen(viewModel = LoginViewModel())

}