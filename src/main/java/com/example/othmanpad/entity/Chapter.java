package com.example.othmanpad.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Long id ;
    private String author;
    private String title;
    private String content;



}
