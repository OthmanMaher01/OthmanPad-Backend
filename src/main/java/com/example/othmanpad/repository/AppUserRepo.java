package com.example.othmanpad.repository;

import com.example.othmanpad.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUsername(String username);
}
