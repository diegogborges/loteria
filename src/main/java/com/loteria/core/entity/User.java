package com.loteria.core.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    private String id;
    private String name;
    private String nickname;

}
