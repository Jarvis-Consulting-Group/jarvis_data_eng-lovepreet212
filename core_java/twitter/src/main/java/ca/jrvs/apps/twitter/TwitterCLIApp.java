package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHtttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TwitterCLIApp {
    public static final String Usage="Usage:TwitterCLIApp post,show or delete tweet";
    private static Controller controller;
    @Autowired
    public TwitterCLIApp(Controller controller) {
        this.controller=controller;
    }

    public static void main(String[] args) {
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        System.out.println(CONSUMER_KEY+"|"+CONSUMER_SECRET+"|"+ACCESS_TOKEN+"|"+TOKEN_SECRET);
        HttpHelper httpHelper=new TwitterHtttpHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
        CrdDao dao=new TwitterDao(httpHelper);
        TwitterService twitterService=new TwitterService(dao);
        controller=new TwitterController(twitterService);
        TwitterCLIApp twitterCLIApp=new TwitterCLIApp(controller);
        twitterCLIApp.run(args);
    }

    public void run(String[] args) {
        if (args.length==0){
            throw new IllegalArgumentException(Usage);
        }
        switch (args[0].toLowerCase()){
            case "post":
                printTweet(controller.postTweet(args));
                break;
            case "show":
                printTweet((controller.showTweet(args)));
                break;
            case "delete":
                 controller.deleteTweet(args).forEach(this::printTweet);
                 break;
            default:
                throw new IllegalArgumentException(Usage);
        }

    }

    private void printTweet(Tweet tweet) {
        try {
            System.out.println(JsonParser.toJson(tweet,true,false));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
