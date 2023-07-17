package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.JsonParser;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
@JsonIgnoreProperties(ignoreUnknown = true)
@Repository
public class TwitterDao  implements CrdDao<Tweet,String> {
    private static final String api_base="https://api.twitter.com";
    private static final String post_path="/2/tweets";
    private static final String show_path="/1.1/statuses/lookup.json";
    private static final String delete_path="/2/tweets/";
    private static final String query_symbol="?";
    private static final String equals="=";
    private static final int Http_code=201;

    private HttpHelper httpHelper;
    @Autowired
    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper=httpHelper;
    }
    @Override
    public Tweet create(Tweet tweet) {
        URI uri;
        String string;
        JSONObject ob= new JSONObject();
        try {
            string=tweet.getText();
            ob =new JSONObject();
            ob.put("text",string);
            //ob.put("coordinates",tweet.getCoordinates().getCoordinates());
            uri=new URI(api_base+post_path);
        } catch (URISyntaxException | JSONException e) {
            throw new RuntimeException(e);
        }

        HttpResponse response;
        try {
            response = httpHelper.httpPost(uri, new StringEntity(ob.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return parseResponseBody(response,Http_code);

    }


    private Tweet parseResponseBody(HttpResponse response, int htttpCode) {
        Tweet tweet;
        //Check status
        int status = response.getStatusLine().getStatusCode();
        if(status!=htttpCode)
        {
            try{
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            System.out.println("Response has no entity");
        }
            throw new RuntimeException("Unexpected HTTP status: " + status);
        }
        if(response.getEntity() == null)
        {
            throw new RuntimeException("Empty Response Body");
        }

        String json_string,sub_str;
        try {
            json_string = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert entity to String", e);
        }

        //Convert JSON String into Tweet Object
        try {
            //sub_str=json_string.substring(1, json_string.length()-1);
            tweet = JsonParser.toObjectFromJson(json_string, Tweet.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tweet;

    }

    @Override
    public Tweet findById(String s) {
        URI uri;
        try {
            uri = new URI(api_base+show_path+query_symbol+"id"+equals+s);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpResponse response = httpHelper.httpGet(uri);
        return parseShowResponseBody(response,200);
    }
    private Tweet parseShowResponseBody(HttpResponse response, int htttpCode) {
        Tweet tweet;
        //Check status
        int status = response.getStatusLine().getStatusCode();
        if(status!=htttpCode)
        {
            try{
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                System.out.println("Response has no entity");
            }
            throw new RuntimeException("Unexpected HTTP status: " + status);
        }
        if(response.getEntity() == null)
        {
            throw new RuntimeException("Empty Response Body");
        }

        String json_string,sub_str;
        try {
            json_string = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert entity to String", e);
        }

        //Convert JSON String into Tweet Object
        try {
            sub_str=json_string.substring(1, json_string.length()-1);
            tweet = JsonParser.toObjectFromJson(sub_str, Tweet.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tweet;

    }

    @Override
    public Tweet deleteById(String id) {
        HttpResponse response=httpHelper.httpDelete(URI.create(api_base+delete_path+id));
        return parseResponseBody(response,200);
    }
}
