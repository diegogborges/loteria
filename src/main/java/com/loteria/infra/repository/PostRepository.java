package com.loteria.infra.repository;

import com.loteria.core.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
