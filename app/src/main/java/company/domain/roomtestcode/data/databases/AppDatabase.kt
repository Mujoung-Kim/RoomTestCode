package company.domain.roomtestcode.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase

import company.domain.roomtestcode.data.databases.dao.TodoDao
import company.domain.roomtestcode.data.databases.entity.Todo

@Database(version = 1, entities = [Todo::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun TodoDao(): TodoDao

}