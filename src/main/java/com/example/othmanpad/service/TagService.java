package com.example.othmanpad.service;


import com.example.othmanpad.entity.Tag;
import com.example.othmanpad.repository.TagRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TagService {

    private final TagRepo tagRepo;

    public Tag createTag(Tag tag){
        return tagRepo.save(tag);

    }

    public List<Tag>createTags(List<Tag> tags){
        return tagRepo.saveAll(tags);
    }

}
