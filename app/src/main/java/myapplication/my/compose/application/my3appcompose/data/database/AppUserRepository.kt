package myapplication.my.compose.application.my3appcompose.data.database

import jakarta.inject.Inject
import myapplication.my.compose.application.my3appcompose.data.database.dao.AppUserDao
import myapplication.my.compose.application.my3appcompose.login.domain.AppUser
import myapplication.my.compose.application.my3appcompose.mapper.AppUserMapper

class AppUserRepository @Inject constructor(
    private val appUserDao: AppUserDao
){

    suspend fun getAllUsers():List<AppUser>{
        val repsonse = appUserDao.getAllUser()
        return repsonse.map { AppUserMapper.toDomain(it) }
    }

    suspend fun addUsers(users: List<AppUser>){
         appUserDao.insertUsers(users.map { AppUserMapper.toEntity(it) })
    }

}
