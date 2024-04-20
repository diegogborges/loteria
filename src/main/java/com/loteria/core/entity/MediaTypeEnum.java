package com.loteria.core.entity;

import lombok.*;

@RequiredArgsConstructor()
@Getter
public enum MediaTypeEnum {

    VIDEO("video"),
    PHOTO("photo"),
    AUDIO("audio");

    private final String type;
}
