package com.loteria.api.v1.controller;

import com.loteria.api.v1.payload.request.PostRequest;
import com.loteria.api.v1.payload.response.PostResponse;
import com.loteria.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    List<PostResponse> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostById(
            @PathVariable String postId) {
        final PostResponse postResponse = this.postService.findById(postId);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PostResponse> save(@RequestBody PostRequest postRequest) {
        final PostResponse postResponse
                = this.postService.save(postRequest);

        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> update(@RequestBody PostRequest postRequest,
                                               @PathVariable String postId) {
        final PostResponse postResponse
                = this.postService.update(postRequest, postId);

        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String postId) {
        postService.delete(postId);
    }
}
