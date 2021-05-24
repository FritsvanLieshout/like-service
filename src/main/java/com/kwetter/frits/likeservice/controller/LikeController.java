package com.kwetter.frits.likeservice.controller;

import com.kwetter.frits.likeservice.entity.LikeViewModel;
import com.kwetter.frits.likeservice.logic.LikeLogicImpl;
import com.kwetter.frits.likeservice.logic.UserLikeLogicImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    private final LikeLogicImpl likeLogic;
    private final UserLikeLogicImpl userLikeLogic;

    public LikeController(LikeLogicImpl likeLogic, UserLikeLogicImpl userLikeLogic) {
        this.likeLogic = likeLogic;
        this.userLikeLogic = userLikeLogic;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLikeToTweet(@RequestBody LikeViewModel likeViewModel) {
        try {
            likeLogic.likeTweet(likeViewModel.getTweetId());
            userLikeLogic.likeTweet(likeViewModel.getTweetId(), likeViewModel.getUserId());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeLikeFromTweet(@RequestBody LikeViewModel likeViewModel) {
        try {
            likeLogic.unLikeTweet(likeViewModel.getTweetId());
            userLikeLogic.unLikeTweet(likeViewModel.getTweetId(), likeViewModel.getUserId());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tweet")
    public ResponseEntity<Integer> getLikesByTweet(@RequestBody LikeViewModel likeViewModel) {
        try {
            var likes = likeLogic.getLikesByTweet(likeViewModel.getTweetId());
            if (likes != null && likes > 0) {
                return new ResponseEntity<>(likes, HttpStatus.OK);
            }
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Boolean> userAlreadyLiked(@RequestBody LikeViewModel likeViewModel) {
        try {
            return new ResponseEntity<>(userLikeLogic.findLikesByUser(likeViewModel.getTweetId(), likeViewModel.getUserId()), HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
