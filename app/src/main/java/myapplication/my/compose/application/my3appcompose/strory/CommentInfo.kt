package myapplication.my.compose.application.my3appcompose.strory

import kotlinx.serialization.Serializable

@Serializable
data class CommentInfo(val nickname: String,
                       val content :String,
                       val date:String,
                       val sex:String
)