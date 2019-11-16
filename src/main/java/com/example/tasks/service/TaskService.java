package com.example.tasks.service;

import com.example.tasks.config.exception.NotFoundException;
import com.example.tasks.domain.Log;
import com.example.tasks.domain.Task;
import com.example.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired TaskRepository taskRepository;
    @Autowired LogService logService;


    public Task create(Task task) {
        Task t = taskRepository.save(task);
        logService.create(Log.Type.INFO, "Tarea creada: " + t);
        return t;
    }

    public Task update(Long id, Task task) {
        if (!taskRepository.existsById(id)) throw new NotFoundException("Tarea no existe con id: " + id);
        Task t = taskRepository.getOne(id);
        if (task.getTitle() != null) t.setTitle(task.getTitle());
        if (task.getDescription() != null) t.setDescription(task.getDescription());
        taskRepository.save(t);
        logService.create(Log.Type.INFO, "Tarea actualizada: " + t);
        return t;
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) throw new NotFoundException("Tarea no existe con id: " + id);
        taskRepository.deleteById(id);
        logService.create(Log.Type.INFO, "Tarea eliminada con id: " + id);
    }

    public Task findById(Long id) {
        if (!taskRepository.existsById(id)) throw new NotFoundException("Tarea no existe con id: " + id);
        Task t = taskRepository.getOne(id);
        logService.create(Log.Type.INFO, "Tarea buscada: " + t);
        return t;
    }

    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        logService.create(Log.Type.INFO, "Tareas buscadas, cantidad: " + tasks.size());
        return tasks;
    }

}
