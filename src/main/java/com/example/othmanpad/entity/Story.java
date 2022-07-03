package com.example.othmanpad.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private Long storyId;
    private String name;
    private String description;
    private String category;
    private String cover;
    private Boolean status;
    private String language;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "storyId",
            referencedColumnName = "storyId"
    )
    private Collection<MainCharacter>mainCharacters=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private AppUser author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "storyId",
            referencedColumnName = "storyId"
    )
    private Collection<Chapter>chapters=new ArrayList<>();

    @ManyToMany()
    private Collection<Tag>tags=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "storyId",
            referencedColumnName = "storyId"
    )
    private Collection<Comment>comments=new ArrayList<>();


}
