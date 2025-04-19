package myapplication.my.compose.application.my3appcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import myapplication.my.compose.application.my3appcompose.data.database.dao.AppUserDao
import myapplication.my.compose.application.my3appcompose.data.database.entity.AppUserEntity

@Database( entities = [AppUserEntity::class] , version = 1)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase(){

    abstract fun getAppUserDao(): AppUserDao



}