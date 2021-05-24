package com.kwetter.frits.likeservice.interfaces;

import org.springframework.validation.annotation.Validated;

@Validated
public interface LikeLogic {
    void likeTweet(String tweetId);
    void unLikeTweet(String tweetId);
    Integer getLikesByTweet(String tweetId);
}
