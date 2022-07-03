package com.example.othmanpad.repository;

import com.example.othmanpad.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository <Tag,Long> {
}
