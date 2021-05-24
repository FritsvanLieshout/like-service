package com.kwetter.frits.likeservice.entity;

import java.util.UUID;

public class LikeViewModel {

    private UUID userId;
    private String tweetId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }
}
