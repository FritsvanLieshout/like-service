package com.kwetter.frits.likeservice.repository;

import com.kwetter.frits.likeservice.entity.UserLike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserLikeRepository extends MongoRepository<UserLike, String> {
    UserLike findUserLikeByUserId(UUID userId);
}
