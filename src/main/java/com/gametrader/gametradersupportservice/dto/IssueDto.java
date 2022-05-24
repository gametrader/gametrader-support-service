package com.gametrader.gametradersupportservice.dto;

import com.gametrader.gametradersupportservice.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueDto {
    @NotNull
    private Long id;
    @NotNull
    private Long authorId;
    @NotNull
    private String title;
    @NotNull
    private Category category;
    @NotNull
    private String content;
    @NotNull
    private Boolean isResolved;
}
