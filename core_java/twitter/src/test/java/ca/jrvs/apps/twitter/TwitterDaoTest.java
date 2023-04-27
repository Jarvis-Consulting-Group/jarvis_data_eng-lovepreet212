package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHtttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

public class TwitterDaoTest {
    TwitterDao dao;

    @Before
    public void setUp() throws Exception {
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        System.out.println(CONSUMER_KEY+"|"+CONSUMER_SECRET+"|"+ACCESS_TOKEN+"|"+TOKEN_SECRET);
        HttpHelper httpHelper=new TwitterHtttpHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
        this.dao=new TwitterDao(httpHelper);
    }

    @Test
    public void create() {
        String text="hsrtdfygil";
        float lon=67f;
        float lat=290f;
        Boolean b=false;
        Coordinates coordinates=new Coordinates();
        float[] f =new float[]{lon,lat};
        coordinates.setCoordinates(f);
        coordinates.setType("Point");
        Tweet postTweet =new Tweet(text,coordinates);
        Tweet tweet=dao.create(postTweet);
        System.out.println(tweet.getText());
    }

    @Test
    public void findById() {
        String id="1650597443220676633";
        Tweet tweet=dao.findById(id);
        try {
            System.out.println(JsonParser.toJson(tweet,true,false));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void deleteById() {
        String id="1649480407652376595";
        Tweet tweet=dao.deleteById(id);
    }
}