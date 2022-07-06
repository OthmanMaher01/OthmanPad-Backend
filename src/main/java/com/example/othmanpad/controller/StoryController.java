package com.example.othmanpad.controller;

import com.example.othmanpad.entity.AppUser;
import com.example.othmanpad.entity.Story;
import com.example.othmanpad.entity.Tag;
import com.example.othmanpad.service.AppUserService;
import com.example.othmanpad.service.StoryService;
import com.example.othmanpad.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Slf4j
public class StoryController {

    private final StoryService storyService;
    private final  AppUserService appUserService;
    private final TagService tagService;

    @PostMapping("/story/add")
    public ResponseEntity<Story> createStory(@RequestBody Story story, HttpServletRequest request){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/story/add").toUriString());
      AppUser appUser = (AppUser) request.getAttribute("user");
         AppUser author  = appUserService.getAppUser(appUser.getUsername());
        story.setAuthor(author);
        List<Tag> tags = (List<Tag>) story.getTags();
        tags.forEach(tag -> {
            Tag temp= tagService.findTag(tag.getTagName());
            if(temp != null){
                tag.setTagId(temp.getTagId());
            }
        });
        tagService.createTags(tags);
        return ResponseEntity.created(uri).body(storyService.createStory(story));
    }


    @GetMapping("/story/tag/{tagName}")
    public ResponseEntity<List<Story>> getStoriesByTag(@PathVariable String tagName){
        return ResponseEntity.ok().body(storyService.getStoriesByTag(tagName));
    }

    @GetMapping("/user/story/{userId}")
    public ResponseEntity<List<Story>> getStoriesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok().body(storyService.getStoriesByUserId(userId));
    }

    @GetMapping("/story/{storyId}")
    public ResponseEntity<Story>getStoryByStoryId(@PathVariable Long storyId){
        return ResponseEntity.ok().body(storyService.getStoryByStoryId(storyId));
    }

}
