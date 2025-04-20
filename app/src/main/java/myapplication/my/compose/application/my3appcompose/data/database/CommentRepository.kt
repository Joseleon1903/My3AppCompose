package myapplication.my.compose.application.my3appcompose.data.database

import jakarta.inject.Inject
import myapplication.my.compose.application.my3appcompose.data.database.dao.CommentDao
import myapplication.my.compose.application.my3appcompose.strory.CommentInfo
import myapplication.my.compose.application.my3appcompose.mapper.CommentInfoMapper

class CommentRepository @Inject constructor(
    private val commentDao: CommentDao
){

    suspend fun getAllComment():List<CommentInfo>{
        val repsonse = commentDao.getAllComment()
        return repsonse.map { CommentInfoMapper.toDomain(it) }
    }

    suspend fun addComment(comment: CommentInfo){
        commentDao.insertComment(CommentInfoMapper.toEntity(comment))
    }

}