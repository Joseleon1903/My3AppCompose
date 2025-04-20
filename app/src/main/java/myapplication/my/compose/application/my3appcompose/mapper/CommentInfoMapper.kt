package myapplication.my.compose.application.my3appcompose.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import myapplication.my.compose.application.my3appcompose.data.database.entity.CommentEntity
import myapplication.my.compose.application.my3appcompose.strory.CommentInfo

class CommentInfoMapper {


    companion object {

        fun toDomain(entity : CommentEntity): CommentInfo {
            return CommentInfo(entity.nickname, entity.content, entity.date, entity.sex)
        }

        fun toEntity(entity : CommentInfo): CommentEntity {
            return CommentEntity(0, entity.nickname, entity.content, entity.date, entity.sex)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toNew(nickname: String,
                  content :String,
                  date:String,
                  sex:String): CommentInfo {
            return CommentInfo(nickname, content, date, sex)
        }
    }

}