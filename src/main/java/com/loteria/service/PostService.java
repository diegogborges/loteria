package com.loteria.service;

import com.loteria.api.v1.payload.request.PostRequest;
import com.loteria.api.v1.payload.response.PostResponse;
import com.loteria.core.entity.Post;

import java.util.List;

public interface PostService {

    PostResponse save(final PostRequest postRequest);

    PostResponse update(final PostRequest postRequest, final String postId);

    void delete(final String postId);

    List<PostResponse> findAll();

    PostResponse findById(final String postId);

    Post findByIdOrThrow(final String postId);
}
