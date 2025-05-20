package com.yavuzeroglu.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yavuzeroglu.todoapp.data.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    suspend fun loadTask(): List<Task>

    @Query("SELECT * FROM tasks WHERE name LIKE '%' || :query || '%'")
    suspend fun searchTasks(query: String): List<Task>

    @Insert
    suspend fun create(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}