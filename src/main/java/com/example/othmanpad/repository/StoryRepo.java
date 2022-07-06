package com.example.othmanpad.repository;

import com.example.othmanpad.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoryRepo extends JpaRepository<Story,Long> {
    @Query(
            value = "SELECT * FROM story s INNER JOIN story_tags st ON s.story_id = st.story_story_id INNER JOIN tag t on st.tags_tag_id = t.tag_id where t.tag_name=?1",
            nativeQuery = true
    )
    List<Story>findStoriesByTagName(String tagName);

    List<Story>findStoriesByAuthorUserId(Long userId);
    Story findStoryByStoryId(Long storyId);
    @Query(
            value = "SELECT * FROM story s INNER JOIN chapter c on s.story_id = c.story_id where chapter_id=?1",
            nativeQuery = true
    )
    Story findStoryByChapterId(Long chapterId);

}
