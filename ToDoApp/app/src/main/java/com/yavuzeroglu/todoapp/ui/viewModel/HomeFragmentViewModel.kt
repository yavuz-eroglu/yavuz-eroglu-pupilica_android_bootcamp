package com.yavuzeroglu.todoapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yavuzeroglu.todoapp.data.entity.Task
import com.yavuzeroglu.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var taskRepository: TaskRepository) : ViewModel() {
    var taskList = MutableLiveData<List<Task>>()


    init {
        loadTasks()
    }

    fun loadTasks() {
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.loadTasks()
        }
    }

    fun searchTask(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.searchTask(query)
        }
    }

    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.delete(id)
            loadTasks()
        }
    }
}