package com.loteria.api.v1.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostResponse {

    private String id;
    private String title;
    private String description;
    private String tag;
    private String userId;
    private String mediaType;
    private String tagType;
    private List<String> collaborators;
}
