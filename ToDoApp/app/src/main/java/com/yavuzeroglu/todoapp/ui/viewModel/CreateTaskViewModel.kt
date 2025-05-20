package com.yavuzeroglu.todoapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.yavuzeroglu.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTaskViewModel @Inject constructor(var taskRepository: TaskRepository) : ViewModel() {

    fun create(name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.create(name)
        }
    }
}