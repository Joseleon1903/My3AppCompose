package myapplication.my.compose.application.my3appcompose.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "App_User_tbl")
data class AppUserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "email") val email:String,
    @ColumnInfo(name = "password")  val password:String,
    @ColumnInfo(name = "creation_date")val creationDate: LocalDateTime,
)