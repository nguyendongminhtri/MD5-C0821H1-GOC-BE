package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
