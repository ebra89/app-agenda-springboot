package com.aton.informatica.appagendaspringboot.repositories;

import com.aton.informatica.appagendaspringboot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
