package myapplication.my.compose.application.my3appcompose.strory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentViewModel  @Inject constructor(private val storyUsesCase: StoryUsesCase) : ViewModel(){


    private val _comments = MutableLiveData<List<CommentInfo>>();
    val comments : LiveData<List<CommentInfo>> = _comments;

    fun onCreate(){

        println("Entering CommentViewModel on create")

    }

     suspend fun getComments() {
         val response =  storyUsesCase.getAllComments();
         _comments.value = response
    }

    suspend fun addComment(comment : CommentInfo){
        println("Insert into database comment : $comment")
        storyUsesCase.insertNewComment(comment);
        getComments()
    }


}
