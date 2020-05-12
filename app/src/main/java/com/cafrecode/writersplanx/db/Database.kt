package com.cafrecode.writersplanx.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "messages")
data class Message(
    val title: String,
    val text: String,
    var imageUrl: String?,
    var time: Long?
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}

@Dao
interface MessageDao {
    @Insert
    fun insert(data: Message)

    @Query("SELECT * FROM messages")
    fun list(): LiveData<List<Message>>
}

@Database(
    entities = [Message::class],
    version = 2
)
abstract class PlanxDatabase :  RoomDatabase(){

    companion object {
        @JvmStatic
        val DATABASE_NAME: String = "planx.db"
    }

    abstract fun messageDao(): MessageDao
}