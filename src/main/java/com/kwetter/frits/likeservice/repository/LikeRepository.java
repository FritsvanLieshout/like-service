package com.kwetter.frits.likeservice.repository;

import com.kwetter.frits.likeservice.entity.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
    Like findLikeByTweetId(String tweetId);
}
