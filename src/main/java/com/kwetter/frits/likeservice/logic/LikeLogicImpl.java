package com.kwetter.frits.likeservice.logic;

import com.kwetter.frits.likeservice.entity.Like;
import com.kwetter.frits.likeservice.interfaces.LikeLogic;
import com.kwetter.frits.likeservice.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeLogicImpl implements LikeLogic {

    private final LikeRepository likeRepository;

    public LikeLogicImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void likeTweet(String tweetId) {
        var like = likeRepository.findLikeByTweetId(tweetId);
        if (like == null) {
            likeRepository.save(new Like(tweetId, 1));
        }
        else {
            like.setCount(like.getCount() + 1);
            likeRepository.save(like);
        }
    }

    @Override
    public void unLikeTweet(String tweetId) {
        var like = likeRepository.findLikeByTweetId(tweetId);
        if (like != null && like.getCount() > 0) {
            like.setCount(like.getCount() - 1);
            likeRepository.save(like);
        }
    }

    @Override
    public Integer getLikesByTweet(String tweetId) {
        var like = likeRepository.findLikeByTweetId(tweetId);
        if (like != null) {
            if (like.getCount() != 0) {
                return like.getCount();
            }
        }
        return 0;
    }
}
