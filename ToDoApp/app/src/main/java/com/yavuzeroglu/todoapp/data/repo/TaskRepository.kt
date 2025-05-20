package com.yavuzeroglu.todoapp.data.repo

import com.yavuzeroglu.todoapp.data.dataSource.TaskDataSource
import com.yavuzeroglu.todoapp.data.entity.Task

class TaskRepository(var taskDataSource: TaskDataSource) {

    suspend fun loadTasks() : List<Task> = taskDataSource.loadTasks()

    suspend fun searchTask(query: String) : List<Task> = taskDataSource.searchTask(query)

    suspend fun create(name: String) = taskDataSource.create(name)

    suspend fun update(id: Int, name: String) = taskDataSource.update(id, name)

    suspend fun delete(id: Int) = taskDataSource.delete(id)
}