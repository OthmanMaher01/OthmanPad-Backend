package com.example.othmanpad.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @SequenceGenerator(
            name="tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )

    private Long tagId;
    @Column(unique = true)
    private String tagName;


}
