package ca.jrvs.apps.twitter.service;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class TwitterService implements Service{
    private CrdDao dao;
    @Autowired
    public TwitterService(@Qualifier("crdDao") CrdDao dao){
        this.dao = dao;
    }
    @Override
    public Tweet postTweet(Tweet tweet) {
        validatePostTweet(tweet);
        return (Tweet) dao.create(tweet);
    }

    private void validatePostTweet(Tweet tweet) {
        if(tweet.getText().length()>140){
            throw new IllegalArgumentException("Tweet characters exceeds limit: 140");
        }
    }

    @Override
    public Tweet showTweet(String id, String[] fields) {

        if(id==null){
            throw new IllegalArgumentException("Id must contain a value");
        }
        if(validateId(id)){

            Tweet tweet=(Tweet) dao.findById(id);
            Tweet output=new Tweet();
            if(fields == null){
                return tweet;
            }
            for(String field:fields){
                if(field.equals("created_at")){
                    output.setCreatedAt(tweet.getCreatedAt());
                }
                if(field.equals("id")){
                    output.setId(tweet.getId());
                }
                if(field.equals("id_str")) {
                    output.setIdStr(tweet.getIdStr());
                }
                if(field.equals("text")){
                    output.setText(tweet.getText());
                }
                if(field.equals("entities")){
                    output.setEntities(tweet.getEntities());
                }
                if(field.equals("coordinates")){
                    output.setCoordinates(tweet.getCoordinates());
                }
                if(field.equals("retweet_count")){
                    output.setRetweetCount(tweet.getRetweetCount());
                }
                if(field.equals("favorite_count")){
                    output.setFavCount(tweet.getFavCount());
                }
                if(field.equals("retweeted")){
                    output.setRetweeted(tweet.getRetweeted());
                }
                if(field.equals("favorited")){
                    output.setFavorited(tweet.getFavorited());
                }

            }
            return output;
        }
        else {
            throw new IllegalArgumentException("ID must contain only numbers");
        }
    }

    private Boolean validateId(String id) {
        for (char c : id.toCharArray())
        {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    @Override
    public List<Tweet> deleteTweets(String[] ids) {
        List<Tweet> list=new ArrayList<>();
        for(String i:ids){
            if(i==null){
                throw new IllegalArgumentException("Id must contain a value");
            }
            if(validateId(i)){
               Tweet tweet= (Tweet) dao.deleteById(i);
               list.add(tweet);
            }
        }
        return list;
    }
}
