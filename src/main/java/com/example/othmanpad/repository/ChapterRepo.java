package com.example.othmanpad.repository;

import com.example.othmanpad.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepo extends JpaRepository<Chapter,Long> {

    Chapter findChapterByChapterId(Long chapterId);

}
