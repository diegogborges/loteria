package com.loteria.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tagtype")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TagType {

    @Id
    private String id;
    private String description;
}
