package com.aton.informatica.appagendaspringboot.repositories;

import com.aton.informatica.appagendaspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.email = ?1")
    User findOne(String email);


    List<User> findByNomeLike(String nome);

}
