package com.loteria.api.v1.controller;

import com.loteria.api.v1.payload.request.UserRequest;
import com.loteria.api.v1.payload.response.UserResponse;
import com.loteria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<UserResponse> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable String userId) {
        final UserResponse userResponse = this.userService.findById(userId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        final UserResponse userResponse
                = this.userService.save(userRequest);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest,
                                                  @PathVariable String userId) {
        final UserResponse userResponse
                = this.userService.update(userRequest, userId);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String userId) {
        userService.delete(userId);
    }
}
