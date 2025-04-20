package myapplication.my.compose.application.my3appcompose.strory

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun CommentList(comments: List<CommentInfo>) {

    Column {
        comments.forEach { item->
            CommentItem(item)
        }
    }


}