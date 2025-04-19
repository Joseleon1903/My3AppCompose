package myapplication.my.compose.application.my3appcompose.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import myapplication.my.compose.application.my3appcompose.data.database.entity.AppUserEntity
import myapplication.my.compose.application.my3appcompose.login.domain.AppUser
import java.time.LocalDateTime

class AppUserMapper {

    companion object {

        fun toDomain(entity : AppUserEntity):AppUser{
            return AppUser(entity.id, entity.email, entity.password, entity.creationDate)
        }

        fun toEntity(entity : AppUser):AppUserEntity{
            return AppUserEntity(entity.id, entity.email, entity.password, entity.creationDate)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toNew(username: String, password: String): AppUser{
            return AppUser(0,username, password,LocalDateTime.now() )
        }
    }
}