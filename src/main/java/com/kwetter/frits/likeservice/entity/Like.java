package com.kwetter.frits.likeservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "like")
public class Like {

    @Id
    private String id;

    private String tweetId;
    private int count;

    public Like() {}

    public Like(String tweetId, int count) {
        this.tweetId = tweetId;
        this.count = count;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTweetId() { return tweetId; }

    public void setTweetId(String tweetId) { this.tweetId = tweetId; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }
}
