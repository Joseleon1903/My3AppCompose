package myapplication.my.compose.application.my3appcompose.login.domain

import java.time.LocalDateTime

data class AppUser( val id:Int,
                   val email:String,
                   val password:String,
                   val creationDate: LocalDateTime
)