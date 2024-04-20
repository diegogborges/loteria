package com.loteria.api.v1.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String id;
    private String name;
    private String nickname;
}
