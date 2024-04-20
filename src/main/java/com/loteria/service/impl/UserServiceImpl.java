package com.loteria.service.impl;

import com.loteria.api.v1.payload.request.UserRequest;
import com.loteria.api.v1.payload.response.UserResponse;
import com.loteria.core.entity.User;
import com.loteria.exception.NotFoundException;
import com.loteria.infra.repository.UserRepository;
import com.loteria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserResponse save(final UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .nickname(userRequest.getNickname())
                .build();

        user = userRepository.save(user);

        return prepareResponse(user);
    }

    public UserResponse update(final UserRequest userRequest, final String userId) {
        User user = this.findByIdOrThrow(userId);
        user.setName(userRequest.getName());
        user.setNickname(userRequest.getNickname());

        user = userRepository.save(user);
        return prepareResponse(user);
    }

    public void delete(final String userId) {
        final User user = this.findByIdOrThrow(userId);
        userRepository.delete(user);
    }

    public List<UserResponse> findAll() {
        final List<User> users = this.userRepository.findAll();

        List<UserResponse> usersResponse = new ArrayList<>();
        users.forEach(user -> usersResponse.add(prepareResponse(user)));

        return usersResponse;
    }

    public UserResponse findById(final String userId) {
        final User user = this.findByIdOrThrow(userId);
        return prepareResponse(user);
    }

    public User findByIdOrThrow(final String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("User with id: %s not found!", userId)));
    }

    private UserResponse prepareResponse(final User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .build();
    }
}
