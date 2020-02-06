package com.aton.informatica.appagendaspringboot.repositories;

import com.aton.informatica.appagendaspringboot.entities.Task;
import com.aton.informatica.appagendaspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long >{


    @Query("select t from Task t where t.user = ?1")
    List<Task> findByUser(User user);
}
