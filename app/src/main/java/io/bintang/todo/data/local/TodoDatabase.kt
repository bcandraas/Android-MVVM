package io.bintang.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.bintang.todo.data.local.dao.TodoDao
import io.bintang.todo.data.local.entity.Todo
import io.bintang.todo.util.Converters

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}