package com.yavuzeroglu.todoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yavuzeroglu.todoapp.data.entity.Task
import com.yavuzeroglu.todoapp.databinding.CardTasarimBinding
import com.yavuzeroglu.todoapp.ui.fragment.HomeFragmentDirections
import com.yavuzeroglu.todoapp.ui.viewModel.HomeFragmentViewModel

class TaskAdapter(var taskList: List<Task>, var viewModel: HomeFragmentViewModel) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(var binding: CardTasarimBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        holder.binding.taskNameTV.text = taskList[position].name

        holder.binding.cardViewSatir.setOnClickListener {
            Navigation
                .findNavController(it)
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(taskList[position]))
        }

        holder.binding.deleteImageView.setOnClickListener {
            Snackbar.make(it, "${
                taskList[position].name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.delete(taskList[position].id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


}