package com.example.mySite.comment;

import com.example.mySite.post.Post;
import com.example.mySite.user.AppUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime modifyDate;

    @ManyToOne
    private AppUser writer;

    @ManyToOne
    private Post post;
}
