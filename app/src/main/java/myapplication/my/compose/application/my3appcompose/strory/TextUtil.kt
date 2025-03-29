package myapplication.my.compose.application.my3appcompose.strory

import kotlinx.serialization.json.Json

class TextUtil {

    companion object  {

        val SexMale = "MALE"
        val SexFemale = "FEMALE"

        val slaveryDescripctiobn: String =
            "La esclavitud en América fue un sistema brutal que marcó profundamente la historia del continente. Desde el siglo XVI hasta el XIX," +
                    " millones de personas africanas fueron capturadas, transportadas en condiciones inhumanas y forzadas a trabajar en plantaciones," +
                    " minas y hogares, especialmente en las colonias europeas. Este sistema no solo despojó a las personas esclavizadas de su libertad," +
                    " sino que también dejó cicatrices sociales, económicas y culturales que perduran hasta hoy. La abolición de la esclavitud, " +
                    "lograda en distintos momentos según el país, fue el resultado de siglos de resistencia y lucha por la dignidad y los derechos humanos."

    }

    fun commentsToString(comments: List<CommentInfo>): String {
        return Json.encodeToString(comments)
    }
    fun stringToComments(json: String): MutableList<CommentInfo> {
        val commentsList = Json.decodeFromString<List<CommentInfo>>(json)
        return commentsList as MutableList<CommentInfo>
    }


}