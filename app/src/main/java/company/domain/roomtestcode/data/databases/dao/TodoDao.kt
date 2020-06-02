package company.domain.roomtestcode.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import company.domain.roomtestcode.data.databases.entity.Todo

@Dao
interface TodoDao {
    @Query("select * from Todos")
    fun getAll(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)

}