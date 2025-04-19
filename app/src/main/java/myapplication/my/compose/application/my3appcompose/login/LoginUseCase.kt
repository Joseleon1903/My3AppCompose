package myapplication.my.compose.application.my3appcompose.login

import android.os.Build
import androidx.annotation.RequiresApi
import myapplication.my.compose.application.my3appcompose.data.database.AppUserRepository
import myapplication.my.compose.application.my3appcompose.login.domain.AppUser
import myapplication.my.compose.application.my3appcompose.mapper.AppUserMapper
import javax.inject.Inject

class LoginUseCase @Inject constructor (private val appUserRepository: AppUserRepository) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(username:String, password:String) : Boolean{

        println("Entering in LoginUseCase")


        val usersDb = appUserRepository.getAllUsers()

        println("usuario encontrados "+usersDb.size )

        val userValid = usersDb.find { it.email.equals(username, true) && it.password.equals(password, true) }

        if(userValid != null){
            println("el usuario es valido")
            println("return successful")
            return true
        }

        val userExist = usersDb.find { it.email.equals(username, true)}

        if(userExist != null){
            println("error usuario con contraseña equivocada")
            return false
        }

        println("el usuario no existe agregandolo a la base de datos...")
        val newuser : AppUser = AppUserMapper.toNew(username, password)
        val insertList = arrayListOf<AppUser>();
        insertList.add(newuser)
        appUserRepository.addUsers(insertList)
        println("return successful")
        return true
    }

}