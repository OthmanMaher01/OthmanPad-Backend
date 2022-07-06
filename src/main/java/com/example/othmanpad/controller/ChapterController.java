package com.example.othmanpad.controller;


import com.example.othmanpad.entity.AppUser;
import com.example.othmanpad.entity.Chapter;
import com.example.othmanpad.entity.Comment;
import com.example.othmanpad.entity.Story;
import com.example.othmanpad.service.AppUserService;
import com.example.othmanpad.service.ChapterService;
import com.example.othmanpad.service.CommentService;
import com.example.othmanpad.service.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Slf4j
public class ChapterController {

    private final ChapterService chapterService;
    private final CommentService commentService;
    private final AppUserService appUserService;
    private final StoryService storyService;

    @PostMapping("/chapter")
    public ResponseEntity<Chapter>saveChapter(@RequestBody  Chapter chapter){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/chapter").toUriString());
        return ResponseEntity.created(uri).body(chapterService.saveChapter(chapter));
    }

    @PostMapping("/chapter/comment")
    public ResponseEntity<Comment>addComment(@RequestBody Comment comment, HttpServletRequest request){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/chapter/comment").toUriString());
        AppUser appUser = (AppUser) request.getAttribute("user");
        AppUser user  = appUserService.getAppUser(appUser.getUsername());
        comment.setUser(user);
        Story story = storyService.getStoryByChapterId(comment.getChapterId());
        AppUser author = story.getAuthor();
        if(author==user){
            comment.setIsWriter(true);
        }
        else {
            comment.setIsWriter(false);
        }
        return ResponseEntity.created(uri).body(commentService.addComment(comment));

    }

    @GetMapping("chapter/{chapterId}")
    public ResponseEntity<Chapter>getChapterByChapterId(@PathVariable Long chapterId){
        return ResponseEntity.ok().body(chapterService.getChapterByChapterId(chapterId));
    }


}
