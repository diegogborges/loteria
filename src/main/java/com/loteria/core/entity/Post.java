package com.loteria.core.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Post {

    @Id
    private String id;
    private String title;
    private String description;
    private String tag;
    private String userId;
    private MediaTypeEnum mediaType;
    private TagType tagType;
    private List<String> collaborators;
}
