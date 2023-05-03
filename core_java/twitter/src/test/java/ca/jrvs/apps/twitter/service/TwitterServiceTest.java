package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.JsonParser;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHtttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceTest {
    TwitterDao dao;
    TwitterService twitterService;

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
    }

    @Test
    public void postTweet() {
        Tweet postTweet=new Tweet();
        postTweet.setText("boom boom");
        Tweet created_tweet=twitterService.postTweet(postTweet);
    }

    @Test
    public void showTweet() {
        String id="1651601729484365825";
        String[] arr={"created_at","id","coordinates","text"};
        Tweet tweet=twitterService.showTweet(id,arr);
        try {
            System.out.println(JsonParser.toJson(tweet,true,false));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deleteTweets() {
        String[] id={"1650907355893186568","1650881214289526788"};
        List<Tweet> tweet=twitterService.deleteTweets(id);

    }
}