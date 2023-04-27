package ca.jrvs.apps.twitter.controller;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Controller
public class TwitterController implements Controller {
    private static final String comma=",";

    Tweet tweet =new Tweet();
    Service twitterService;
    @Autowired
    public TwitterController(Service service) {
        twitterService=service;
    }

    @Override
    public Tweet postTweet(String[] args) {
        if(args.length!=2){
            throw new IllegalArgumentException("Usage:TwitterCliApp-> Post: text");
        }
        String text=args[1];
        tweet.setText(text);
        return twitterService.postTweet(tweet);
    }

    @Override
    public Tweet showTweet(String[] args) {
        if(args.length<2 && args.length>11){
            throw new IllegalArgumentException("Usage:TwitterCliApp-> ShowTweet");
        }
        String id=args[1];
        String[] fields=args[2].split(",");
        return twitterService.showTweet(id,fields);
    }

    @Override
    public List<Tweet> deleteTweet(String[] args) {
        if(args.length==0){
            throw new IllegalArgumentException("Usage:TwitterCliApp-> Require atleast one id to delete");
        }

        return twitterService.deleteTweets(args);

    }
}
