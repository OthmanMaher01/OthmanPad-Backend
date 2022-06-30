package com.example.othmanpad.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {
    @Id
    @SequenceGenerator(
            name="story_sequence",
            sequenceName = "story_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "story_sequence"
    )
    private Long id;
    private String name;
    private String description;
    //Many to many Tag
    // One to many chapter
    private String category;
    private String cover;
    private Boolean status;
    private Collection<String> mainCharacters = new ArrayList<>();
    private String language;
    // comments


}
