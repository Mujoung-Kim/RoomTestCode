package company.domain.roomtestcode.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room

import company.domain.roomtestcode.data.databases.AppDatabase
import company.domain.roomtestcode.data.databases.entity.Todo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    //  TODO view 에서 처리할 동작
    private val database = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "RoomTest.db"
    ).build()
    var todos: LiveData<List<Todo>>
    var newTodos: String? = null

    init {
        todos = getAll()

    }

    fun getAll(): LiveData<List<Todo>> = database.TodoDao().getAll()

    //  coroutine 에서만 동작하도록 suspend fun 으로 선언함.
    fun insert(todo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            database.TodoDao().insert(Todo(todo))

        }
    }
}