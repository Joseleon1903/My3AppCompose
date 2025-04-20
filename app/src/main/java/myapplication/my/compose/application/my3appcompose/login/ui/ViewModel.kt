package myapplication.my.compose.application.my3appcompose.login.ui

import android.os.Build
import android.util.Patterns
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import myapplication.my.compose.application.my3appcompose.login.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel(){

    private val _email = MutableLiveData<String>();
    val email : LiveData<String> = _email;

    private val _password = MutableLiveData<String>();
    val password : LiveData<String> = _password;

    private val _loginEnable = MutableLiveData<Boolean>();
    val loginEnable : LiveData<Boolean> = _loginEnable;

    private val _isLoading = MutableLiveData<Boolean>();
    val isLoading : LiveData<Boolean> = _isLoading;

    fun onCreate(){

        println("Entering on create")

    }
    
    fun onValueLoginChange(email:String , password:String){
        //asignando valores
        _email.value = email;
        _password.value = password;

        _loginEnable.value = isValidEmail(email) && isValidPassowrd(password)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun onLoginSelected(navigateToScreen : () -> Unit){
        println("entring in onLoginSelected")
        _isLoading.value = true;
        delay(4000)

        val result = loginUseCase.invoke(_email.toString(), _password.toString())
        _isLoading.value = false;

        if(result) {
            println("login successful")
            navigateToScreen()
        }
        println("login $result")
    }

    private fun isValidPassowrd(pass: String): Boolean {
        if(pass.length >= 6){
            return true
        }
        return false
    }

    private fun isValidEmail(email: String): Boolean= Patterns.EMAIL_ADDRESS.matcher(email).matches()


}