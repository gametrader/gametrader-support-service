package com.gametrader.gametradersupportservice.entity;


import com.gametrader.gametradersupportservice.model.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "issue")
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_resolved", nullable = false)
    private Boolean isResolved;
}
