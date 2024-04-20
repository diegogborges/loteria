package com.loteria.api.v1.payload.request;

import lombok.Getter;

import java.util.List;

@Getter
public class PostRequest {

    private String title;
    private String description;
    private String tag;
    private String userId;
    private String mediaType;
    private String tagType;
    private List<String> collaborators;
}
