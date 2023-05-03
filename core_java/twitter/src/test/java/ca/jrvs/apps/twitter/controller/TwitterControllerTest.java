package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.JsonParser;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHtttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerTest {
    TwitterDao dao;
    TwitterService twitterService;
    TwitterController twitterController;
    @Before
    public void setUp() throws Exception {
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        System.out.println(CONSUMER_KEY+"|"+CONSUMER_SECRET+"|"+ACCESS_TOKEN+"|"+TOKEN_SECRET);
        HttpHelper httpHelper=new TwitterHtttpHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
        this.dao=new TwitterDao(httpHelper);
        twitterService=new TwitterService(this.dao);
        twitterController=new TwitterController(twitterService);
    }

    @Test
    public void postTweet() {
        String[] args={"my name is chicky","my name boom boom"};
        Tweet created_tweet=twitterController.postTweet(args);
    }

    @Test
    public void showTweet() {
        String[] args={"1651601729484365825","text","created_at"};
        Tweet created_tweet=twitterController.showTweet(args);
        try {
            System.out.println(JsonParser.toJson(created_tweet,true,false));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void deleteTweet() {
        List<Tweet> delete;
        String[] args={"1650569659085643797","1650568182531252241","1645493358243061771"};
        delete=twitterController.deleteTweet(args);
    }
}