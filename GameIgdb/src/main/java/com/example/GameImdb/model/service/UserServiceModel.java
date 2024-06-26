package com.example.GameImdb.model.service;

import com.example.GameImdb.model.entity.UserRoleEntity;


import java.util.Set;

public class UserServiceModel {
    private Long id;
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;


    private Integer age;

    private Set<UserRoleEntity> roles;

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserServiceModel setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
