package com.yavuzeroglu.todoapp.di

import android.content.Context
import androidx.room.Room
import com.yavuzeroglu.todoapp.data.dataSource.TaskDataSource
import com.yavuzeroglu.todoapp.data.repo.TaskRepository
import com.yavuzeroglu.todoapp.room.Database
import com.yavuzeroglu.todoapp.room.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTaskRepository(taskDataSource: TaskDataSource): TaskRepository {
        return TaskRepository(taskDataSource)
    }

    @Provides
    @Singleton
    fun provideTaskDataSource(taskDao: TaskDao): TaskDataSource {
        return TaskDataSource(taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskDao(@ApplicationContext context: Context): TaskDao {
        val database = Room.databaseBuilder(context, Database::class.java, "yapilacaklar.sqlite")
            .createFromAsset("yapilacaklar.sqlite")
            .build()
        return database.getTaskDao()
    }
}