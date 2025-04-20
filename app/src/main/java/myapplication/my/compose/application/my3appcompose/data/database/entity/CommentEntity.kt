package myapplication.my.compose.application.my3appcompose.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Comment_tbl")
data class CommentEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id :Int = 0,
    @ColumnInfo(name = "nickname")
    val nickname: String,
    @ColumnInfo(name = "content")
    val content :String,
    @ColumnInfo(name = "date")
    val date:String,
    @ColumnInfo(name = "sex")
    val sex:String
)