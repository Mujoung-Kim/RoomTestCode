package company.domain.roomtestcode.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todos")
data class Todo(
    @ColumnInfo(name = "todo_title")
    val title: String

) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}