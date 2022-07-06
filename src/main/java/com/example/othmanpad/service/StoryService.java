package com.example.othmanpad.service;

import com.example.othmanpad.entity.Story;
import com.example.othmanpad.repository.StoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class StoryService {

    private final StoryRepo storyRepo;

    public Story createStory (Story story){

        return storyRepo.save(story);

    }

    public List<Story>getStoriesByTag(String tagName){
        return storyRepo.findStoriesByTagName(tagName);
    }


    public List<Story>getStoriesByUserId(Long userId){
        return storyRepo.findStoriesByAuthorUserId(userId);
    }

    public Story getStoryByStoryId(Long storyId){
        return storyRepo.findStoryByStoryId(storyId);
    }

    public Story getStoryByChapterId(Long chapterId){
        return storyRepo.findStoryByChapterId(chapterId);
    }


}
