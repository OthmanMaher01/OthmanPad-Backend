package com.example.othmanpad.service;

import com.example.othmanpad.entity.Story;
import com.example.othmanpad.repository.StoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class StoryService {

    private final StoryRepo storyRepo;

    public Story createStory (Story story){

        return storyRepo.save(story);

    }




}
