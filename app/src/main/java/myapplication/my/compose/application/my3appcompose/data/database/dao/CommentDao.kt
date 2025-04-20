package myapplication.my.compose.application.my3appcompose.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import myapplication.my.compose.application.my3appcompose.data.database.entity.CommentEntity

@Dao
interface CommentDao {

    @Query("select * from Comment_tbl order by id asc")
    suspend fun getAllComment(): List<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: CommentEntity)

}