package myapplication.my.compose.application.my3appcompose.strory

import myapplication.my.compose.application.my3appcompose.data.database.CommentRepository
import javax.inject.Inject

class StoryUsesCase @Inject constructor (private val commentRepository: CommentRepository) {


    suspend fun getAllComments(): List<CommentInfo>{
        val response = commentRepository.getAllComment()
        return response;
    }

    suspend fun insertNewComment(comment: CommentInfo){
        val response = commentRepository.addComment(comment)
    }

}