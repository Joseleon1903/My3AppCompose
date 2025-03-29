package myapplication.my.compose.application.my3appcompose.strory

object CommentDatabaseManager {

    val commentsStore : MutableList<CommentInfo> = mutableListOf(CommentInfo("nickname", "content", "date", "MALE"));

    fun get():  MutableList<CommentInfo> {
        println("get commentsStore " + commentsStore.size)
        return commentsStore;
    }

    fun add(item : CommentInfo){
        commentsStore.add(item);
        println("add commentsStore " + commentsStore.size)
    }
}