package com.kwetter.frits.likeservice.interfaces;

import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface UserLikeLogic {
    void likeTweet(String tweetId, UUID userId);
    void unLikeTweet(String tweetId, UUID userId);
    Boolean findLikesByUser(String tweetId, UUID userId);
}
