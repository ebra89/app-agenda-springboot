package com.aton.informatica.appagendaspringboot.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    private String nome;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Role(String nome, List<User> users) {

        this.nome = nome;
        this.users = users;
    }
    public Role() {

    }
    public Role(String nome) {

        this.nome = nome;
    }
}
