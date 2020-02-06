package com.aton.informatica.appagendaspringboot.services;

import com.aton.informatica.appagendaspringboot.entities.Task;
import com.aton.informatica.appagendaspringboot.entities.User;
import com.aton.informatica.appagendaspringboot.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {

        task.setUser(user);
        taskRepository.save(task);

    }

    public List<Task> findUserTask(User user){

        return taskRepository.findByUser(user);
    }


}
