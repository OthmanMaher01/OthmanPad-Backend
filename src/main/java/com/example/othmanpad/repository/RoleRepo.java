package com.example.othmanpad.repository;

import com.example.othmanpad.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
