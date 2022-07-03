package com.example.othmanpad.controller;

import com.example.othmanpad.entity.AppUser;
import com.example.othmanpad.entity.Role;
import com.example.othmanpad.entity.Story;
import com.example.othmanpad.entity.Tag;
import com.example.othmanpad.service.AppUserService;
import com.example.othmanpad.service.StoryService;
import com.example.othmanpad.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

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
        log.info("{}",tags);
        tagService.createTags(tags);



        return ResponseEntity.created(uri).body(storyService.createStory(story));
    }

}
