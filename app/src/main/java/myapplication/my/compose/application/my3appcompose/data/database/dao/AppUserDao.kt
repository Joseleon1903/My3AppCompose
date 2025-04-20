package myapplication.my.compose.application.my3appcompose.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myapplication.my.compose.application.my3appcompose.data.database.entity.AppUserEntity

@Dao
interface AppUserDao {

    @Query("select * from App_User_tbl order by email desc")
    suspend fun getAllUser(): List<AppUserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<AppUserEntity>)

}