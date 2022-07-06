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
public class Chapter {

    @Id
    @SequenceGenerator(
            name="chapter_sequence",
            sequenceName = "chapter_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "chapter_sequence"
    )
    private Long chapterId;
    private String title;
    private String content;
    private Long storyId;

        @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "chapterId",
            referencedColumnName = "chapterId"
    )
    private Collection<Comment>comments=new ArrayList<>();



}
