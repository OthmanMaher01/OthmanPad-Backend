package com.example.othmanpad.service;

import com.example.othmanpad.entity.Chapter;
import com.example.othmanpad.repository.ChapterRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ChapterService {

    private final ChapterRepo chapterRepo;

    public Chapter saveChapter(Chapter chapter){
        return chapterRepo.save(chapter);
    }

    public Chapter getChapterByChapterId(Long chapterId){
        return chapterRepo.findChapterByChapterId(chapterId);
    }


}
