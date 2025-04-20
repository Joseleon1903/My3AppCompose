package myapplication.my.compose.application.my3appcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import myapplication.my.compose.application.my3appcompose.data.database.UserDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val USER_DATABASE_NAME = "UserDataBase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context,
        UserDatabase::class.java, USER_DATABASE_NAME).build();


    @Singleton
    @Provides
    fun provideUserDao(db : UserDatabase) = db.getAppUserDao();

    @Singleton
    @Provides
    fun provideCommentDao(db : UserDatabase) = db.getCommentDao();

}