package com.loteria.infra.repository;

import com.loteria.core.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
