package com.example.othmanpad.service;


import com.example.othmanpad.entity.Comment;
import com.example.othmanpad.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommentService {

    private final CommentRepo commentRepo;

    public Comment addComment(Comment comment){
        return commentRepo.save(comment);
    }


}
