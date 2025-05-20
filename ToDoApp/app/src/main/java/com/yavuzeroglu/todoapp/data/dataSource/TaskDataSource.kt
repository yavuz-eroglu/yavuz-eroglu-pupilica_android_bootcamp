package com.yavuzeroglu.todoapp.data.dataSource

import com.yavuzeroglu.todoapp.data.entity.Task
import com.yavuzeroglu.todoapp.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var taskDao: TaskDao) {

    suspend fun loadTasks(): List<Task> = withContext(Dispatchers.IO) {
        return@withContext taskDao.loadTask()
    }

    suspend fun searchTask(query: String): List<Task> = withContext(Dispatchers.IO) {
        return@withContext taskDao.searchTasks(query)
    }

    suspend fun create(name: String) {
        val newTask = Task(0, name)
        taskDao.create(newTask)
    }

    suspend fun delete(id: Int) {
        val deleteTask = Task(id, "")
        taskDao.delete(deleteTask)
    }

    suspend fun update(id: Int, name: String) {
        val updatedTask = Task(id, name)
        taskDao.update(updatedTask)
    }
}