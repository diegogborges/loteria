package com.loteria.service;

import com.loteria.api.v1.payload.request.UserRequest;
import com.loteria.api.v1.payload.response.UserResponse;
import com.loteria.core.entity.User;

import java.util.List;

public interface UserService {

    UserResponse save(final UserRequest userRequest);
    UserResponse update(final UserRequest userRequest, final String userId);
    void delete(final String userId);
    List<UserResponse> findAll();
    UserResponse findById(final String userId);
    User findByIdOrThrow(final String userId);
}
