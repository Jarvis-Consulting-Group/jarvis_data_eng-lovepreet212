package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.URI;

public class TwitterHtttpHelper implements HttpHelper {
    private OAuthConsumer consumer;
    private HttpClient httpClient;
    public TwitterHtttpHelper(String consumerKey, String consumerSecret,String accessToken,String tokenSecret){
        consumer=new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        consumer.setTokenWithSecret(accessToken,tokenSecret);
        httpClient=new DefaultHttpClient();
    }

    public HttpResponse httpPost(URI uri) {
        try {
            return executeHttpRequest(HttpMethod.POST,uri,null);
        } catch (OAuthException|IOException e) {
            throw new RuntimeException(e);
        }

    }

    private HttpResponse executeHttpRequest(HttpMethod post, URI uri, Object o) {

    }

    @Override
    public HttpResponse httpGet(URI uri) {
        return null;
    }
}
