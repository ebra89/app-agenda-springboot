package com.aton.informatica.appagendaspringboot.services;

import com.aton.informatica.appagendaspringboot.entities.Role;
import com.aton.informatica.appagendaspringboot.entities.User;
import com.aton.informatica.appagendaspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }
    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }


    public User findOne(String email) {

        return userRepository.findOne(email);

    }
    public boolean userPresente(String email) {
        User u = userRepository.findOne(email);
        if(u!= null) {
            return true;
        }
        return false;
    }
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<User> findByNome(String nome) {

        return userRepository.findByNomeLike("%"+nome+"%");
    }
}
