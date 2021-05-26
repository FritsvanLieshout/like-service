package com.kwetter.frits.likeservice.logic;

import com.kwetter.frits.likeservice.entity.UserLike;
import com.kwetter.frits.likeservice.interfaces.UserLikeLogic;
import com.kwetter.frits.likeservice.repository.UserLikeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserLikeLogicImpl implements UserLikeLogic {

    private final UserLikeRepository userLikeRepository;

    public UserLikeLogicImpl(UserLikeRepository userLikeRepository) {
        this.userLikeRepository = userLikeRepository;
    }

    @Override
    public void likeTweet(String tweetId, UUID userId) {
        var userLikes = userLikeRepository.findUserLikeByUserId(userId);
        if (userLikes != null) {
            var likes = userLikes.getLikes();
            likes.add(tweetId);
            userLikes.setLikes(likes);
            userLikeRepository.save(userLikes);
        }
        else {
            List<String> likes = new ArrayList<>();
            likes.add(tweetId);
            userLikeRepository.save(new UserLike(userId, likes));
        }
    }

    @Override
    public void unLikeTweet(String tweetId, UUID userId) {
        var userLikes = userLikeRepository.findUserLikeByUserId(userId);
        if (userLikes != null) {
            var likes = userLikes.getLikes();
            likes.remove(tweetId);
            userLikes.setLikes(likes);
            userLikeRepository.save(userLikes);
        }
    }

    @Override
    public Boolean findLikesByUser(String tweetId, UUID userId) {
        var userLikes = userLikeRepository.findUserLikeByUserId(userId);
        if (userLikes != null) {
            var likes = userLikes.getLikes();
            for (var like : likes) {
                if (like.equals(tweetId)) return true;
            }
        }
        return false;
    }

    @Override
    public UserLike findUserLikes(UUID userId) {
        return userLikeRepository.findUserLikeByUserId(userId);
    }
}
