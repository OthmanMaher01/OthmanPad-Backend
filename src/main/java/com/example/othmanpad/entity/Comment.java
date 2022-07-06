package com.example.othmanpad.entity;

import com.example.othmanpad.sideclasses.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @SequenceGenerator(
            name="comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long commentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private AppUser user;
    private String content;
    private Boolean isWriter;
    private Long chapterId;
}

