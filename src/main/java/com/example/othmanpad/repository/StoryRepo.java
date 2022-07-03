package com.example.othmanpad.repository;

import com.example.othmanpad.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepo extends JpaRepository<Story,Long> {


}
