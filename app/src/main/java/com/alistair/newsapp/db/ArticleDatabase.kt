package com.alistair.newsapp.db

import android.content.Context
import androidx.room.*
import com.alistair.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao // room does the implementation for this behind the scenes

    // to create our database
    companion object {
        @Volatile // other threads can immediately see when a thread changes this instance

        private var instance: ArticleDatabase? = null

        // To synchronise the instance, to make sure, there is only one instance of our db at once
        private val LOCK = Any()

        // Called whenever an instance of the object is created
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()

    }

}