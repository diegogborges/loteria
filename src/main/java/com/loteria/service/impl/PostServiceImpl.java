package com.loteria.service.impl;

import com.loteria.api.v1.payload.request.PostRequest;
import com.loteria.api.v1.payload.response.PostResponse;
import com.loteria.core.entity.MediaTypeEnum;
import com.loteria.core.entity.Post;
import com.loteria.exception.NotFoundException;
import com.loteria.infra.repository.PostRepository;
import com.loteria.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostResponse save(final PostRequest postRequest) {
        Post post = Post.builder()
                .title(postRequest.getTitle())
                .tag(postRequest.getTag())
                .description(postRequest.getDescription())
                .mediaType(MediaTypeEnum.PHOTO)
                .userId(postRequest.getUserId())
                .collaborators(postRequest.getCollaborators())
                .build();

        post = postRepository.save(post);

        return prepareResponse(post);
    }

    public PostResponse update(final PostRequest postRequest, final String postId) {
        Post post = this.findByIdOrThrow(postId);
        post.setTitle(postRequest.getTitle());
        post.setTag(postRequest.getTag());
        post.setDescription(postRequest.getDescription());
        post.setMediaType(MediaTypeEnum.PHOTO);
        post.setUserId(postRequest.getUserId());
        post.setCollaborators(postRequest.getCollaborators());

        post = postRepository.save(post);
        return prepareResponse(post);
    }

    public void delete(final String postId) {
        final Post post = this.findByIdOrThrow(postId);
        postRepository.delete(post);
    }

    public List<PostResponse> findAll() {
        final List<Post> posts = this.postRepository.findAll();

        List<PostResponse> postsResponse = new ArrayList<>();
        posts.forEach(post -> postsResponse.add(prepareResponse(post)));

        return postsResponse;
    }

    public PostResponse findById(final String postId) {
        final Post post = this.findByIdOrThrow(postId);
        return prepareResponse(post);
    }

    public Post findByIdOrThrow(final String postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Post with id: %s not found!", postId)));
    }

    private PostResponse prepareResponse(final Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .tag(post.getTag())
                .description(post.getDescription())
                .mediaType(MediaTypeEnum.PHOTO.getType())
                .userId(post.getUserId())
                .collaborators(post.getCollaborators())
                .build();
    }
}
