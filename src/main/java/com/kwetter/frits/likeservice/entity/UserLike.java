package com.kwetter.frits.likeservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document(collection = "user_like")
public class UserLike {

    @Id
    private String id;

    @Field("user_id")
    private UUID userId;

    private List<String> likes;

    public UserLike() {}

    public UserLike(UUID userId, List<String> likes) {
        this.userId = userId;
        this.likes = likes;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public UUID getUserId() { return userId; }

    public void setUserId(UUID userId) { this.userId = userId; }

    public List<String> getLikes() { return likes; }

    public void setLikes(List<String> likes) { this.likes = likes; }
}
